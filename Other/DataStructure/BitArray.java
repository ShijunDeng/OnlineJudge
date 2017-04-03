package cn.sjdeng.ds;


/*
 移动公司需要对已经发放的所有139段的号码进行统计排序,已经发放的139号码段的文件
 存放在一个文本文件中( 原题是放在两个文件中),一个号码一行,现在需要将文 件里的
 所有号码进行排序,并写入到一个新的文件中；号码 可能会有很多,最多可能有一亿个不
 同的号码(所有的139段号码), 存入文本文件中大概要占1.2G的空间；jvm最大的内存
 在300以内, 程序要考虑程序的可执行性及效率；只能使用Java标准库,不得使用第三方
 工具。 这是个典型的大数据量的排序算法问题,首先要考虑空间问题,一下把1.2G的数据
 读入内存是不太可能的,就算把1一亿条数据,转都转 换成int类型存储也要占接近400M的
 空间。当时做个题目我并没有想太多 的执行效率问题,主要就考虑了空间,而且习惯性的
 想到合并排序,基 本思想是原文件分割成若干个小文件并排序,再将排序好的小文件合并
 得到最后结果,算法大概如下：
  
  1.顺序读取存放号码文件的中所有号码,并取139之后的八位转换为int类型；每
    读取号码数满一百万个,(这个数据可配置)将已经读取的号码排序并存入新建的临时文件。
  2.将所有生成的号码有序的临时文件合并存入结果文件。
  
  这个算法虽然解决了空间问题,但是运行效率极低,由于IO读写操作太多,加上步骤1中的
  排序的算法(快速排序)本来效率就不高(对于电话排序这种特殊情况来说),导致1亿
  条数据排序运行3个小时才有结果。
  
  如果和能够减少排序的时间呢？首当其冲的减少IO操作,另外如果能够有更加好排序算法也
  行。：用位向量存储电话号码,一个号码占一个bit,  一亿个电话号码也只需要大概12M的
  空间；算法大概如下：
    1.初始化bits[capacity]； 
    2.顺序所有读入电话号码,并转换为int类型,修改位向量值：bits[phoneNum]=1；
    3.遍历bits数组,如果bits[index]=1,转换index为电话号码输出。

 
 这个算法很快，不过也有他的局限性： 
    1.只能用于整数的排序，或者可以准确映射到正整数（对象不同对应的正整数也不相同）的数据的排序。 
    2.不能处理重复的数据，重复的数据排序后只有一条（如果有这种需求可以在这个算法的基础上修改，
      给出现次数大于1的数据添加个计数器，然后存入Map中） 
    3.对于数据量极其大的数据处理可能还是比较占用空间，这种情况可配合多通道排序算法解决。
 */
public class BitArray {
	private int[] bits = null;
	private int length;
	// 用于设置或者提取int类型的数据的某一位(bit)的值时使用
	private final static int[] bitValue = { 
			0x80000000, // 10000000 00000000 00000000 00000000
			0x40000000, // 01000000 00000000 00000000 00000000
			0x20000000, // 00100000 00000000 00000000 00000000
			0x10000000, // 00010000 00000000 00000000 00000000
			0x08000000, // 00001000 00000000 00000000 00000000
			0x04000000, // 00000100 00000000 00000000 00000000
			0x02000000, // 00000010 00000000 00000000 00000000
			0x01000000, // 00000001 00000000 00000000 00000000
			0x00800000, // 00000000 10000000 00000000 00000000
			0x00400000, // 00000000 01000000 00000000 00000000
			0x00200000, // 00000000 00100000 00000000 00000000
			0x00100000, // 00000000 00010000 00000000 00000000
			0x00080000, // 00000000 00001000 00000000 00000000
			0x00040000, // 00000000 00000100 00000000 00000000
			0x00020000, // 00000000 00000010 00000000 00000000
			0x00010000, // 00000000 00000001 00000000 00000000
			0x00008000, // 00000000 00000000 10000000 00000000
			0x00004000, // 00000000 00000000 01000000 00000000
			0x00002000, // 00000000 00000000 00100000 00000000
			0x00001000, // 00000000 00000000 00010000 00000000
			0x00000800, // 00000000 00000000 00001000 00000000
			0x00000400, // 00000000 00000000 00000100 00000000
			0x00000200, // 00000000 00000000 00000010 00000000
			0x00000100, // 00000000 00000000 00000001 00000000
			0x00000080, // 00000000 00000000 00000000 10000000
			0x00000040, // 00000000 00000000 00000000 01000000
			0x00000020, // 00000000 00000000 00000000 00100000
			0x00000010, // 00000000 00000000 00000000 00010000
			0x00000008, // 00000000 00000000 00000000 00001000
			0x00000004, // 00000000 00000000 00000000 00000100
			0x00000002, // 00000000 00000000 00000000 00000010
			0x00000001 // 00000000 00000000 00000000 00000001
	};

	public BitArray(int length) {
		if (length < 0) {
			throw new IllegalArgumentException("length must be above zero!");
		}
		bits = new int[length / 32 + ((length % 32) > 0 ? 1 : 0)];
		this.length = length;
	}

	public int getBit(int index) {
		if (index < 0 || index > length) {
			throw new IllegalArgumentException("length value illegal!");
		}

		int intData = bits[index / 32];
		return ((intData & bitValue[index % 32]) >>> (32 - index % 32 - 1));
	}

	public void setBit(int index, int value) {
		if (index < 0 || index > length) {
			throw new IllegalArgumentException("length value illegal!");
		}

		if (value != 1 && value != 0) {
			throw new IllegalArgumentException("value must be 1 or 0!");
		}

		int intData = bits[index / 32];

		if (value == 1) {
			bits[index / 32] = intData | bitValue[index % 32];
		} else {
			bits[index / 32] = intData & ~bitValue[index % 32];
		}
	}

	public int getLength() {
		return length;
	}

	public static void main(String[] args) {
		BitArray bitArray = new BitArray(100000);
		bitArray.setBit(100, 1);
		System.out.println(bitArray.getBit(100));
	}
}
