package groupb;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import req.Request;
import req.Request.ReqType;
import req.RequestCallback;

public class HDFSDump implements RequestCallback {

	@Override
	public List<Integer> call(Request request) {
		if (request.type.equals(ReqType.SEQ_READ)) {
			System.out.println("###########READ");
			// System.out.println("Path::" + request.path);
			// System.out.println("Start::" + request.start);
			// System.out.println("End::" + request.end);
			String command = "./hdfsWriteTest.sh 1M 500";
			Process proc = null;
			try {
				proc = Runtime.getRuntime().exec(command);

				Scanner scanner = new Scanner(proc.getInputStream());
				while (scanner.hasNext()) {
					System.out.println(scanner.nextLine());
				}
				scanner.close();

//				proc.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} //catch (InterruptedException e) {
//				e.printStackTrace();
//			}


		}
//		if (request.type.equals(ReqType.SEQ_WRITE)) {
//			System.out.println("###########Write");
//			// System.out.println("Path::" + request.path);
//			// System.out.println("Start::" + request.start);
//			// System.out.println("End::" + request.end);
//			String command = "ssh groupb@groupb13 \"ssh hduser@hdfsMaster \"hdfs dfs -put /home/hduser/Desktop/test.txt /\"; exit\"; exit";
//			Process proc = null;
//			try {
//				proc = Runtime.getRuntime().exec(command);
//
//				Scanner scanner = new Scanner(proc.getInputStream());
//				while (scanner.hasNext()) {
//					System.out.println(scanner.nextLine());
//				}
//				scanner.close();
//
//				proc.waitFor();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		return null;
	}

}
