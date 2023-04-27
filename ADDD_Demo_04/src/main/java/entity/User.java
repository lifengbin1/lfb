package entity;

/**
 * @author DarryYang
 *
 */
public class User {

	private Integer uid;
	private String uname;
	private String uphone;
	private int uage;
	private String utime;
	private String usex;

	public User(Integer uid, String uname, String uphone, int uage, String utime, String usex) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uphone = uphone;
		this.uage = uage;
		this.utime = utime;
		this.usex = usex;
	}


	public String getUsex() {
		return usex;
	}


	public void setUsex(String usex) {
		this.usex = usex;
	}


	public User() {
		// TODO Auto-generated constructor stub
	}

	public Integer getUid() {
		return uid;
	}

	public String getUtime() {
		return utime;
	}

	public void setUtime(String utime) {
		this.utime = utime;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public int getUage() {
		return uage;
	}

	public void setUage(int uage) {
		this.uage = uage;
	}

}
