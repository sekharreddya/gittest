package com.tag.componentId;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeComplonentId {
	
	
	/*@GeneratedValue(generator="emp_code_gen")
	@GenericGenerator(name="emp_code_gen",strategy="com.tag.idgenerator.EmpIdGeneratior")
	@Column(name="emp_code")*/
	private String empCode;

	
	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empCode == null) ? 0 : empCode.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeComplonentId other = (EmployeeComplonentId) obj;
		if (empCode == null) {
			if (other.empCode != null)
				return false;
		} else if (!empCode.equals(other.empCode))
			return false;
		return true;
	}
}
