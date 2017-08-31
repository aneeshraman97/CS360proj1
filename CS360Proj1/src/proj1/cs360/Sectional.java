package proj1.cs360;

import java.util.ArrayList;

public class Sectional {
	private String host;
	private ArrayList<School>schools;
	private  int size;
	private boolean added;
	private int count=0;
	private String type;
	private boolean full;
	public Sectional(String host, ArrayList<School>schools,int size){
		this.host="";
		this.schools=schools;
		this.size=size;
		this.added=false;
		this.full=false;
	}
	
	public boolean isFull() {
		return full;
	}

	public void setFull(boolean full) {
		this.full = full;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Sectional(String host,School x, int size){
		this.schools=new ArrayList<School>();
		this.host=host;
		this.schools.add(x);
		this.size=size;
		this.added=false;
		this.full=false;
	}
	public void addSchools(School x){
		
		this.schools.add(x);
		if(this.schools.size()>=this.size)
			this.setFull(true);
	}
	public School getHostSchool(){
		return this.schools.get(0);
	}
	
	public ArrayList<School> getSchools() {
		return schools;
	}
	public void addArraySchools(School[] x){
		for(int i=0;i<x.length;i++)
			this.addSchools(x[i]);
	}
	public boolean findSchool(School x){
		ArrayList<School> temp=this.getSchools();
		for(int i=0;i<temp.size();i++){
			if(x.getName().equals(temp.get(i).getName()))
				return true;
		}
		return false;
	}
	public void setSchools(ArrayList<School> schools) {
		this.schools = schools;
	}
	public String toString(){
		String x="";
		x+="Host Name: "+host+"\n";
		//System.out.println(schools.size());
		for(int i=0;i<schools.size();i++)
			x=x+schools.get(i).toString()+"\n";
		return x;
	}
	public String getHost() {
		return host;
	}


	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}

	public void setHost(String host) {
		this.host = host;
	}


	/*public School[] getSchools() {
		return schools;
	}


	public void setSchools(School[] schools) {
		this.schools = schools;
	}*/
	
	

	public int getCount() {
		return count;
	}


	public String getType() {
		return type;
	}


	/*public boolean addSchool(School toBeAdded){
		/*if(this.count>=this.size)
			return false;*/
			/*School []temp=new School[this.schools.length];
			for(int i=0;i<this.schools.length;i++){
				temp[i]=this.schools[i];
			}
			this.schools=new School[temp.length+1];
			for(int i=0;i<temp.length;i++)
				temp[i]=this.schools[i];
			this.schools[temp.length]=toBeAdded;
			this.count++;
			return true;
		
		}*/
}