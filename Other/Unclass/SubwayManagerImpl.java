package xxx.biz.impl;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;

import huawei.exam.CardEnum;
import huawei.exam.ReturnCodeEnum;
import huawei.exam.SubwayException;
import xxx.biz.CardManager;
import xxx.biz.SubwayManager;
import xxx.model.Card;
import xxx.model.ConsumeRecord;
import xxx.model.Subways;
import xxx.model.Subways.DistanceInfo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * <p>
 * Title: 待考生实现类takeSubway乘车函数，其它已实现功能函数不用关注
 * </p>
 *
 * <p>
 * Description: 车乘中心
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2013
 * </p>
 *
 * <p>
 * Company:
 * </p>
 *
 * @author
 * @version 1.0 OperationCenter V100R002C20, 2015/9/7]
 */
public class SubwayManagerImpl implements SubwayManager {
	private static final String SUBWAY_NAME = "subwayName";
	private static final String FIRST_STATION = "firstStation";
	private static final String LAST_STATION = "lastStation";

	private Subways subways = new Subways();
	private CardManager cardManager;
	private Table<String, String, Integer> shortestDistances;

	public SubwayManagerImpl(CardManager cardManager) {
		this.cardManager = cardManager;
	}

	private void initShortestDistancesFloyd() {
		shortestDistances = HashBasedTable.create();

		Table<String, String, DistanceInfo> stationInstances = subways.getStationDistances();
		Set<String> stations = stationInstances.rowKeySet();

		for (String row : stations) {
			for (String column : stations) {
				if (row.equals(column)) {
					shortestDistances.put(row, column, 0);
				} else {
					shortestDistances.put(row, column, -1);
					shortestDistances.put(column, row, -1);
				}
			}
		}

		for (String row : stations) {
			Map<String, DistanceInfo> map = stationInstances.row(row);

			for (String column : map.keySet()) {
				Integer distance = stationInstances.get(row, column).getDistance();

				shortestDistances.put(row, column, distance);
				shortestDistances.put(column, row, distance);
			}
		}

		for (String k : stations) {
			for (String row : stations) {
				for (String column : stations) {
					if (shortestDistances.get(row, k) >= 0 && shortestDistances.get(k, column) >= 0) {
						Integer tmp = shortestDistances.get(row, k) + shortestDistances.get(k, column);

						if (shortestDistances.get(row, column) < 0 || shortestDistances.get(row, column) > tmp) {
							shortestDistances.put(row, column, tmp);
							shortestDistances.put(column, row, tmp);
						}
					}
				}
			}
		}
	}

	private String getMinDist(Map<String, Integer> dist, Map<String, Boolean> visited) {
		Integer minDist = Integer.MAX_VALUE;
		String v = null; // graph not connected, or no unvisited vertices
		for (Map.Entry<String, Integer> w : dist.entrySet()) {
			if (visited.get(w.getKey()) == false && w.getValue() < minDist) {
				v = w.getKey();
				minDist = w.getValue();
			}
		}
		return v;
	}

	// 参考http://cs.fit.edu/~ryan/java/programs/graph/Dijkstra-java.html
	private void initShortestDistancesDijkstra() {
		shortestDistances = HashBasedTable.create();

		Table<String, String, DistanceInfo> stationInstances = subways.getStationDistances();
		Set<String> stations = stationInstances.rowKeySet();

		for (String row : stations) {
			for (String column : stations) {
				if (row.equals(column)) {
					shortestDistances.put(row, column, 0);
				} else {
					shortestDistances.put(row, column, -1);
					shortestDistances.put(column, row, -1);
				}
			}
		}

		for (String row : stations) {
			Map<String, DistanceInfo> map = stationInstances.row(row);

			for (String column : map.keySet()) {
				Integer distance = stationInstances.get(row, column).getDistance();

				shortestDistances.put(row, column, distance);
				shortestDistances.put(column, row, distance);
			}
		}

		for (String v0 : stations) {
			Map<String, Boolean> visited = new HashMap<String, Boolean>();
			Map<String, Integer> dist = new HashMap<String, Integer>();
			for (String v : stations) {
				visited.put(v, false);
				dist.put(v, shortestDistances.get(v0, v) > 0 ? shortestDistances.get(v0, v) : Integer.MAX_VALUE);
			}
			dist.put(v0, 0);
			visited.put(v0, true);
			for (String i : stations) {
				// 未访问过的且离v0最近的结点
				String v = getMinDist(dist, visited);
				Integer min = dist.get(v);
				visited.put(v, true);
				// The shortest path to next is dist[next]
				for (String w : stations) {
					if (shortestDistances.get(v, w) != null && shortestDistances.get(v, w) >= 0
							&& visited.get(w) == false) {// 是邻结点
						Integer d = min + shortestDistances.get(v, w);
						if (dist.get(w) > d) {
							dist.put(w, d);
						}
					}
				}
			}
			for (Map.Entry<String, Integer> w : dist.entrySet()) {
				shortestDistances.put(v0, w.getKey(), w.getValue());
				shortestDistances.put(w.getKey(), v0, w.getValue());
			}
		}
	}

	private boolean validStations(String enterStation, String exitStation) {
		Table<String, String, DistanceInfo> stationDistances = subways.getStationDistances();

		return (stationDistances.containsRow(enterStation) && stationDistances.containsColumn(exitStation));
	}

	private boolean validTimes(String enterTime, String exitTime) {
		String regex = "^(\\d){2}(:)(\\d){2}$";
		Pattern pattern = Pattern.compile(regex);

		if (!pattern.matcher(enterTime).matches() || !pattern.matcher(exitTime).matches())
			return false;

		DateFormat dateFormat = new SimpleDateFormat("HH:mm");

		try {
			Date dt1 = dateFormat.parse(enterTime);
			Date dt2 = dateFormat.parse(exitTime);

			if (dt1.getTime() <= dt2.getTime()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return false;
	}

	public Integer getShortestDistance(String enterStation, String exitStation) {
		if (shortestDistances == null)
			initShortestDistancesDijkstra();

		return shortestDistances.get(enterStation, exitStation);
	}

	public Integer calculatePriceForStations(String enterStation, String exitStation) throws SubwayException {
		if (!validStations(enterStation, exitStation)) {
			Card card = new Card();
			card.setCardType(CardEnum.E);

			throw new SubwayException(ReturnCodeEnum.E07, card);
		}

		Integer distance = getShortestDistance(enterStation, exitStation);
		Integer price = 0;

		if (distance < 3000) {
			price = 2;
		} else if (distance < 5000) {
			price = 3;
		} else if (distance < 10000) {
			price = 4;
		} else {
			price = 5;
		}

		return price;
	}

	public Integer calculatePriceForTimes(String enterTime, String exitTime) throws SubwayException {
		if (!validTimes(enterTime, exitTime)) {
			Card card = new Card();
			card.setCardType(CardEnum.E);

			throw new SubwayException(ReturnCodeEnum.E05, card);
		}

		DateFormat dateFormat = new SimpleDateFormat("HH:mm");

		Integer price = 0;
		Integer minutesDiff = 0;

		try {
			Date dt1 = dateFormat.parse(enterTime);
			Date dt2 = dateFormat.parse(exitTime);

			minutesDiff = (int) ((dt2.getTime() - dt1.getTime()) / (1000 * 60));
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		if (minutesDiff <= 30) {
			price = 0;
		} else {
			price = 3;
		}

		return price;
	}

	/**
	 * 乘车 -- 待考生实现
	 *
	 * @param cardId
	 *            the card id
	 * @param enterStation
	 *            the enter station
	 * @param enterTime
	 *            the enter time
	 * @param exitStation
	 *            the exit station
	 * @param exitTime
	 *            the exit time
	 * @return 卡当前状态
	 * @throws SubwayException
	 *             the subway exception
	 */
	@Override
	public Card takeSubway(String cardId, String enterStation, String enterTime, String exitStation, String exitTime)
			throws SubwayException {
		// TODO 待考生实现
		Card card = cardManager.queryCard(cardId);
		if (!validStations(enterStation, exitStation)) {
			throw new SubwayException(ReturnCodeEnum.E07, card);
		} else if (!validTimes(enterTime, exitTime)) {
			throw new SubwayException(ReturnCodeEnum.E05, card);
		}

		Integer billing = 0;
		if (!enterStation.equals(exitStation)) {
			billing = calculatePriceForStations(enterStation, exitStation);
		} else {
			billing = calculatePriceForTimes(enterTime, exitTime);
		}

		cardManager.consume(cardId, billing);

		if (!card.getCardType().equals(CardEnum.A)) {
			List<ConsumeRecord> list = cardManager.queryConsumeRecord(cardId);

			ConsumeRecord record = new ConsumeRecord();
			record.setConsumeMoney(billing);
			record.setEnterStation(enterStation);
			record.setExitStation(exitStation);
			record.setEnterTime(enterTime);
			record.setExitTime(exitTime);

			list.add(record);

			while (list.size() > 20) {
				list.remove(0);
			}
		}

		return card;
	}

	@Override
	public void manageSubways() {
		List<Map<String, String>> subwayMap = new ArrayList<Map<String, String>>();
		Map<String, String> oneSubway = Maps.newHashMap();
		oneSubway.put(FIRST_STATION, "S0");
		oneSubway.put(LAST_STATION, "S8");
		oneSubway.put(SUBWAY_NAME, "0");
		subwayMap.add(oneSubway);

		Map<String, String> secondSubway = Maps.newHashMap();
		secondSubway.put(FIRST_STATION, "S10");
		secondSubway.put(LAST_STATION, "S18");
		secondSubway.put(SUBWAY_NAME, "1");
		subwayMap.add(secondSubway);

		Map<String, String> thirdSubway = Maps.newHashMap();
		thirdSubway.put(FIRST_STATION, "S20");
		thirdSubway.put(LAST_STATION, "S28");
		thirdSubway.put(SUBWAY_NAME, "2");
		subwayMap.add(thirdSubway);

		Map<String, String> forthSubway = Maps.newHashMap();
		forthSubway.put(FIRST_STATION, "S30");
		forthSubway.put(LAST_STATION, "S38");
		forthSubway.put(SUBWAY_NAME, "3");
		subwayMap.add(forthSubway);

		subways.setSubwayInfo(subwayMap);
		subways.setStationDistances(initStationsTable());
	}

	@Override
	public Subways querySubways() {
		return subways;
	}

	private Table<String, String, Subways.DistanceInfo> initStationsTable() {
		Table<String, String, Subways.DistanceInfo> distanceTable = HashBasedTable.create();

		// 0号线
		distanceTable.put("S0", "S1", new Subways.DistanceInfo("0", 800));
		distanceTable.put("S1", "S2", new Subways.DistanceInfo("0", 2168));
		distanceTable.put("S2", "S3", new Subways.DistanceInfo("0", 2098));
		distanceTable.put("S3", "S4", new Subways.DistanceInfo("0", 2165));
		distanceTable.put("S4", "S5", new Subways.DistanceInfo("0", 1500));
		distanceTable.put("S5", "S6", new Subways.DistanceInfo("0", 1345));
		distanceTable.put("S6", "S7", new Subways.DistanceInfo("0", 1567));
		distanceTable.put("S7", "S8", new Subways.DistanceInfo("0", 1897));

		distanceTable.put("S1", "S0", new Subways.DistanceInfo("0", 800));
		distanceTable.put("S2", "S1", new Subways.DistanceInfo("0", 2168));
		distanceTable.put("S3", "S2", new Subways.DistanceInfo("0", 2098));
		distanceTable.put("S4", "S3", new Subways.DistanceInfo("0", 2165));
		distanceTable.put("S5", "S4", new Subways.DistanceInfo("0", 1500));
		distanceTable.put("S6", "S5", new Subways.DistanceInfo("0", 1345));
		distanceTable.put("S7", "S6", new Subways.DistanceInfo("0", 1567));
		distanceTable.put("S8", "S7", new Subways.DistanceInfo("0", 1897));

		// 1号线
		distanceTable.put("S10", "S11", new Subways.DistanceInfo("1", 900));
		distanceTable.put("S11", "S12", new Subways.DistanceInfo("1", 1168));
		distanceTable.put("S12", "S5", new Subways.DistanceInfo("1", 2198));
		distanceTable.put("S5", "S14", new Subways.DistanceInfo("1", 2000));
		distanceTable.put("S14", "S15", new Subways.DistanceInfo("1", 1600));
		distanceTable.put("S15", "S16", new Subways.DistanceInfo("1", 1485));
		distanceTable.put("S16", "S17", new Subways.DistanceInfo("1", 1600));
		distanceTable.put("S17", "S18", new Subways.DistanceInfo("1", 1888));

		distanceTable.put("S11", "S10", new Subways.DistanceInfo("1", 900));
		distanceTable.put("S12", "S11", new Subways.DistanceInfo("1", 1168));
		distanceTable.put("S5", "S12", new Subways.DistanceInfo("1", 2198));
		distanceTable.put("S14", "S5", new Subways.DistanceInfo("1", 2000));
		distanceTable.put("S15", "S14", new Subways.DistanceInfo("1", 1600));
		distanceTable.put("S16", "S15", new Subways.DistanceInfo("1", 1485));
		distanceTable.put("S17", "S16", new Subways.DistanceInfo("1", 1600));
		distanceTable.put("S18", "S17", new Subways.DistanceInfo("1", 1888));

		// 2号线
		distanceTable.put("S20", "S21", new Subways.DistanceInfo("2", 1100));
		distanceTable.put("S21", "S22", new Subways.DistanceInfo("2", 1238));
		distanceTable.put("S22", "S23", new Subways.DistanceInfo("2", 1998));
		distanceTable.put("S23", "S15", new Subways.DistanceInfo("2", 1800));
		distanceTable.put("S15", "S25", new Subways.DistanceInfo("2", 1700));
		distanceTable.put("S25", "S26", new Subways.DistanceInfo("2", 1585));
		distanceTable.put("S26", "S27", new Subways.DistanceInfo("2", 1405));
		distanceTable.put("S27", "S28", new Subways.DistanceInfo("2", 1822));

		distanceTable.put("S21", "S20", new Subways.DistanceInfo("2", 1100));
		distanceTable.put("S22", "S21", new Subways.DistanceInfo("2", 1238));
		distanceTable.put("S23", "S22", new Subways.DistanceInfo("2", 1998));
		distanceTable.put("S15", "S23", new Subways.DistanceInfo("2", 1800));
		distanceTable.put("S25", "S15", new Subways.DistanceInfo("2", 1700));
		distanceTable.put("S26", "S25", new Subways.DistanceInfo("2", 1585));
		distanceTable.put("S27", "S26", new Subways.DistanceInfo("2", 1405));
		distanceTable.put("S28", "S27", new Subways.DistanceInfo("2", 1822));

		// 3号线
		distanceTable.put("S30", "S31", new Subways.DistanceInfo("3", 1110));
		distanceTable.put("S31", "S32", new Subways.DistanceInfo("3", 1338));
		distanceTable.put("S32", "S2", new Subways.DistanceInfo("3", 1568));
		distanceTable.put("S2", "S22", new Subways.DistanceInfo("3", 1450));
		distanceTable.put("S22", "S35", new Subways.DistanceInfo("3", 1680));
		distanceTable.put("S35", "S36", new Subways.DistanceInfo("3", 1345));
		distanceTable.put("S36", "S37", new Subways.DistanceInfo("3", 1555));
		distanceTable.put("S37", "S38", new Subways.DistanceInfo("3", 1682));

		distanceTable.put("S31", "S30", new Subways.DistanceInfo("3", 1110));
		distanceTable.put("S32", "S31", new Subways.DistanceInfo("3", 1338));
		distanceTable.put("S2", "S32", new Subways.DistanceInfo("3", 1568));
		distanceTable.put("S22", "S2", new Subways.DistanceInfo("3", 1450));
		distanceTable.put("S35", "S22", new Subways.DistanceInfo("3", 1680));
		distanceTable.put("S36", "S35", new Subways.DistanceInfo("3", 1345));
		distanceTable.put("S37", "S36", new Subways.DistanceInfo("3", 1555));
		distanceTable.put("S38", "S37", new Subways.DistanceInfo("3", 1682));
		return distanceTable;
	}
}