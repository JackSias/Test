import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

 class UDPDemo2 {
    public static void main(String[] args) throws IOException {
	    DatagramSocket ds = new DatagramSocket();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
	    String line=null;
	    while((line=br.readLine())!=null){
	    	if("886".equals(line)){
	    		break;
	    	}
	    	byte[] buf = line.getBytes();
	    	DatagramPacket dp = new DatagramPacket(buf, buf.length,InetAddress.getByName("10.212.109.90"),10001);
	    	ds.send(dp);
	    }
	    ds.close();
    } 
}

class UDPRece2 {
    public static void main(String[] args) throws IOException  {
    	DatagramSocket ds = new DatagramSocket(10001);
    	while(true){
    		byte[] buf = new byte[1024];//可将其定义成64k
    		DatagramPacket dp = new DatagramPacket(buf, buf.length);
    		ds.receive(dp);
    		String ip = dp.getAddress().getHostAddress();
    		String data = new String(dp.getData(),0,dp.getLength());
    		System.err.println("ip:"+ip+"data :"+data);
    	}
    }
}

