package f_vo;

public class ActionForward { // 추가적으로 옵션값을 주기위해 만든클래스 
	private String path = null;
	private boolean redirect = false;
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	
	
}
