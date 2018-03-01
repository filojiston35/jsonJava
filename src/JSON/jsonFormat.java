/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bilgisayar
 */
public class jsonFormat {
    
    private final HashMap degerler= new HashMap();
    
    public void setObject(String key , Object value) {             
       degerler.put(key,value);       
    }
    public void readObject() 
    {        
    
        int boyut =degerler.size();
        if(boyut==0)
        {
          System.out.println("{}");
        }
        else
        {  
            System.out.print("{");
            jsonFormat(degerler);
            System.out.print("}");
        }
    }
    public void jsonFormat(HashMap<String,Object> deger)
    {
        int length=deger.size();
        for (Map.Entry<String, Object> degeriOku : deger.entrySet()) 
        {
             if(degeriOku.getValue()==null)
                  System.out.print("\""+degeriOku.getKey()+"\":"+null);           
             else if(degeriOku.getValue().getClass()==java.lang.Integer.class)
                   System.out.print("\""+degeriOku.getKey()+"\":"+degeriOku.getValue()); 
             else if(degeriOku.getValue().getClass()==java.lang.Boolean.class)
                   System.out.print("\""+degeriOku.getKey()+"\":"+degeriOku.getValue());                   
             else if(degeriOku.getValue().getClass()==java.lang.Float.class)
                   System.out.print("\""+degeriOku.getKey()+"\":"+degeriOku.getValue()); 
             else if(degeriOku.getValue().getClass()==java.lang.Double.class)
                   System.out.print("\""+degeriOku.getKey()+"\":"+degeriOku.getValue());
             else if(degeriOku.getValue().getClass()==java.lang.String.class)
                   System.out.print("\""+degeriOku.getKey()+"\":\""+degeriOku.getValue()+"\"");  
             else if(degeriOku.getValue().getClass()==java.lang.Character.class)
                   System.out.print("\""+degeriOku.getKey()+"\":"+degeriOku.getValue()); 
             else if(degeriOku.getValue().getClass()==java.lang.Byte.class)
                   System.out.print("\""+degeriOku.getKey()+"\":"+degeriOku.getValue());  
             else if(degeriOku.getValue().getClass()==java.lang.Short.class)
                   System.out.print("\""+degeriOku.getKey()+"\":"+degeriOku.getValue());  
             else if(degeriOku.getValue().getClass()==java.lang.Long.class)
                   System.out.print("\""+degeriOku.getKey()+"\":"+degeriOku.getValue());  
             else if(degeriOku.getValue().getClass()==java.util.HashMap.class)
             {
                 System.out.print("\""+degeriOku.getKey()+"\":{");
                 jsonFormat((HashMap<String,Object>)degeriOku.getValue());
                 System.out.print("}");
             }
             else if(degeriOku.getValue().getClass()==java.util.ArrayList.class)
             {
                 List<Object> tempArray=(ArrayList<Object>)degeriOku.getValue();
                 System.out.print(degeriOku.getKey()+":[");
                 for (int i = 0; i < tempArray.size(); i++)
                 {
                     Object object=tempArray.get(i);
                     if(object.getClass()==java.lang.String.class)
                     {
                         System.out.print("\""+object.toString()+"\"");
                     }
                     else
                         System.out.print(object.toString());
                     
                     if(i!=tempArray.size()-1)
                         System.out.print(",");
                     
                 }
                 System.out.print("]");
             }
             else
                 System.out.print("\""+degeriOku.getKey()+"\":"+degeriOku.getValue().getClass());
                 
             if(length!=1)
             {
               System.out.print(",");
             } 
             length--;                                                             
           }
         
    }
}
