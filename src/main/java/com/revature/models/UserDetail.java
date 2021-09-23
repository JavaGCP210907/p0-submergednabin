package com.revature.models;

public class UserDetail {
	
	private int user_id;
	private String first_name;
	private String last_name;
	private String email;
	private String user_password;
	private int phone_number;
	private String country;
	private String state;
	private String city;
	private String apartment_number;
	private int zip;
	private String date_created_at;
	private String date_updated_at;
	private int user_role_id_fk;
	private int account_id;
	
	public UserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetail(int user_id, String first_name, String last_name, String email, String user_password,
			int phone_number, String country, String state, String city, String apartment_number, int zip,
			String date_created_at, String date_updated_at, int user_role_id_fk, int account_id) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.user_password = user_password;
		this.phone_number = phone_number;
		this.country = country;
		this.state = state;
		this.city = city;
		this.apartment_number = apartment_number;
		this.zip = zip;
		this.date_created_at = date_created_at;
		this.date_updated_at = date_updated_at;
		this.user_role_id_fk = user_role_id_fk;
		this.account_id = account_id;
	}

	public UserDetail(String first_name, String last_name, String email, String user_password, int phone_number,
			String country, String state, String city, String apartment_number, int zip, String date_created_at,
			String date_updated_at, int user_role_id_fk, int account_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.user_password = user_password;
		this.phone_number = phone_number;
		this.country = country;
		this.state = state;
		this.city = city;
		this.apartment_number = apartment_number;
		this.zip = zip;
		this.date_created_at = date_created_at;
		this.date_updated_at = date_updated_at;
		this.user_role_id_fk = user_role_id_fk;
		this.account_id = account_id;
	}
	
	//getters and setters
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public int getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getApartment_number() {
		return apartment_number;
	}

	public void setApartment_number(String apartment_number) {
		this.apartment_number = apartment_number;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getDate_created_at() {
		return date_created_at;
	}

	public void setDate_created_at(String date_created_at) {
		this.date_created_at = date_created_at;
	}

	public String getDate_updated_at() {
		return date_updated_at;
	}

	public void setDate_updated_at(String date_updated_at) {
		this.date_updated_at = date_updated_at;
	}

	public int getUser_role_id_fk() {
		return user_role_id_fk;
	}

	public void setUser_role_id_fk(int user_role_id_fk) {
		this.user_role_id_fk = user_role_id_fk;
	}
	
	
	//hash and equals

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_id;
		result = prime * result + ((apartment_number == null) ? 0 : apartment_number.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((date_created_at == null) ? 0 : date_created_at.hashCode());
		result = prime * result + ((date_updated_at == null) ? 0 : date_updated_at.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + phone_number;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
		result = prime * result + user_role_id_fk;
		result = prime * result + zip;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetail other = (UserDetail) obj;
		if (account_id != other.account_id)
			return false;
		if (apartment_number == null) {
			if (other.apartment_number != null)
				return false;
		} else if (!apartment_number.equals(other.apartment_number))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (date_created_at == null) {
			if (other.date_created_at != null)
				return false;
		} else if (!date_created_at.equals(other.date_created_at))
			return false;
		if (date_updated_at == null) {
			if (other.date_updated_at != null)
				return false;
		} else if (!date_updated_at.equals(other.date_updated_at))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (phone_number != other.phone_number)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		if (user_role_id_fk != other.user_role_id_fk)
			return false;
		if (zip != other.zip)
			return false;
		return true;
	}
	
	
	//object conversion
	@Override
	public String toString() {
		return "UserDetail [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", user_password=" + user_password + ", phone_number=" + phone_number + ", country=" + country
				+ ", state=" + state + ", city=" + city + ", apartment_number=" + apartment_number + ", zip=" + zip
				+ ", date_created_at=" + date_created_at + ", date_updated_at=" + date_updated_at + ", user_role_id_fk="
				+ user_role_id_fk + ", account_id=" + account_id + "]";
	}

		
	
	
	
	
}
