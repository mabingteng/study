package tst.concurrent;

public class TestThreadPool {

	public static void main(String[] args) {
		DefaultThreadPool<Job> tPool = new DefaultThreadPool<>();
		for(int i =0; i<20;i++){
			tPool.execute(new Job());
		}
		tPool.addWorks(2);
		System.out.println(tPool.getJobSize());
		tPool.shutdown();
	}
	static class Job implements Runnable{
		
		@Override
		public void run() {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}
