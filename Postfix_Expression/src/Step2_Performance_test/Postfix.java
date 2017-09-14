import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
class Parser {
	static int lookahead;
	static String test_string;
	static int indexs;
	public Parser(int length) throws IOException {
		test_string = "";
		test_string = new Runner().get_string(length);
		indexs = 0;
		lookahead = test_string.charAt(indexs);
	}

	double expr() throws IOException {
		long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
		term();
		rest();
		long endTime=System.currentTimeMillis(); //��ȡ����ʱ��
		System.out.println("\n��������ʱ�䣺 "+(endTime-startTime)+"ms\n");
		return endTime-startTime;
	}
	
	double expr2() throws IOException {
		long startTime=System.currentTimeMillis();   //��ȡ��ʼʱ��
		term();
		recur_rest();
		long endTime=System.currentTimeMillis(); //��ȡ����ʱ��
		System.out.println("\n��������ʱ�䣺 "+(endTime-startTime)+"ms\n");
		return endTime-startTime;
	}
	
	void rest() throws IOException {
		boolean flag = true;
		while (flag) {
			if (lookahead == '+') {
				match('+');
				term();
				//System.out.write('+');
			} else if (lookahead == '-') {
				match('-');
				term();
				//System.out.write('-');
			} else {
				flag = false;
			}
		}
	}
	
	void recur_rest() throws IOException {
		if (lookahead == '+') {
			match('+');
			term();
			//System.out.write('+');
			recur_rest();
		} else if (lookahead == '-') {
			match('-');
			term();
			//System.out.write('-');
			recur_rest();
		} else {
			// do nothing with the input
		}
	}

	void term() throws IOException {
		if (Character.isDigit((char)lookahead)) {
			//System.out.write((char)lookahead);
			match(lookahead);
		} else  throw new Error("syntax error");
	}

	void match(int t) throws IOException {
		if (lookahead == t)  {
			lookahead = test_string.charAt(++indexs);
		}
		else  throw new Error("syntax error");
	}
}

public class Postfix {
	public static void main(String[] args) throws IOException {
		System.out.println("Input an infix expression and output its postfix notation:");
		File datafile = new File("data.txt");
		if(datafile.exists() && datafile.isFile()) {
		   System.out.println("ʹ���Ѿ����ڵ�data.txt�ļ�");
		  } else {
			  try {
				  //�����ļ�
				  datafile.createNewFile();
				  System.out.println("����data.txt�ļ�");
			  } catch(IOException e) {
				  System.out.println("����data.txt�ļ�ʧ��,������Ϣ��"+e.getMessage());
				  return;
			  }
		  }
		PrintWriter pw = new PrintWriter(datafile);
		pw.write("loop length,           loop totaltimes,           recur totaltimes\n");
		for (int i = 1000; i < 12000; ) {
			i += 500;
			double loop_totaltimes = 0;
			for (int j = 0; j < 1000; j++) {
				loop_totaltimes += new Parser(i).expr();
			}
			double recur_totaltimes = 0;
			for (int j = 0; j < 1000; j++) {
				recur_totaltimes += new Parser(i).expr2();
			}
			String str = "" + i+"  "+loop_totaltimes+ "   "+recur_totaltimes+"  \n";
			pw.write(str);
		}
		pw.close();
		System.out.println("\nEnd of program.");
	}
}
