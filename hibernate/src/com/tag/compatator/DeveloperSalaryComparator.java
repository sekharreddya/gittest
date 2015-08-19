package com.tag.compatator;

import java.util.Comparator;

import com.tag.model.Developers;

public class DeveloperSalaryComparator implements Comparator<Developers> {

	@Override
	public int compare(Developers dev1, Developers dev2) {
		// TODO Auto-generated method stub
		if(dev1.getSal()>dev2.getSal())
			return 1;
		else if(dev1.getSal()<dev2.getSal())
			return -1;
		else
		return 0;
	}

}
