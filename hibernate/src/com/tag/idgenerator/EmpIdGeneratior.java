package com.tag.idgenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmpIdGeneratior implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor sessionImplementor, Object object)
			throws HibernateException {
		
		Serializable result = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
		
        try {
        	String prefix = "EMP";
            connection = sessionImplementor.connection();
            statement = connection.prepareStatement("SELECT LAST_INSERT_ID() as nextval");

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("nextval");
                result = prefix + StringUtils.leftPad("" + id,3, '0');
                
                System.err.println("emp code error"+result);
                
            }

        } catch (SQLException e) {
            
            throw new HibernateException("Unable to generate Stock Code Sequence");
        }
        return result;
    }
	

}
