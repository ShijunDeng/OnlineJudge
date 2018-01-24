package testcase;

import xxx.tool.CommandEnum;
import xxx.tool.OpResult;
import xxx.SubwaySECControlCenter;
import xxx.model.Command;
import xxx.model.OperationResult;

import org.junit.Assert;
import org.junit.Test;

/**
 * 自动化测试类，考生可以实现此类，进行测试。
 * @author
 * @version 1.0
 */
public class TestSubwayManager extends SubwaySECControlCenter
{
    /**
     * 线路查询测试用例
     */
    @Test
    public void testQuerySubways()
    {
        SubwaySECControlCenter impl = new SubwaySECControlCenter();
        Command command = new Command();
        command.setCommand(CommandEnum.CMD_ONCE);
        command.setEnterStation("S1");
        command.setExitStation("S35");     
        OperationResult responseBody = null;     		
        for(int i= 0; i< 10;i++){
        	responseBody=impl.execute(command);
        	System.out.println(OpResult.createReturnResult(CommandEnum.CMD_ONCE, responseBody).toString());
        }
      
    }
}
