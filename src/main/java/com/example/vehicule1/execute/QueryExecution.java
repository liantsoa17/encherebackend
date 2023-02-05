package com.example.vehicule1.execute;

import java.sql.Connection;
import java.sql.Statement;

public class QueryExecution {
    public void myQuery(String query)throws Exception{
        Connection con=null;
        Statement st=null;
        try {
            con=new Connexion().getconnect();
            st= con.createStatement();
            st.execute(query);
        }
        catch (Exception e){

        }
        finally {
            if(con!=null){
                con.close();
            }
            if (st!=null){
                st.close();
            }
        }
    }
}
