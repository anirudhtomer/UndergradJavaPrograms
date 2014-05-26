
package addressparser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import javax.swing.JOptionPane;

/**
 *
 * @author ANIRUDH TOMER
 *         MIT PUNE
 */

//base class 
class Address{
    
    String Street;
    String Locality ;
    String City ;
    String State;
    String PostalCode;
    String Country ;

    public Address() {
        Street = "";
        Locality = "";
        City = "";
        State = "";
        PostalCode = "";
        Country = "";
    }


    //get-set for Street
    String getStreet(){
        return Street;
    }

    void setStreet(String Street){
        this.Street = Street;
    }

    //get-set for Locality
    String getLocality(){
        return Locality;
    }

    void setLocality(String Locality){
        this.Locality = Locality;
    }

    //get-set for City
    String getCity(){
        return City;
    }

    void setCity(String City){
        this.City = City;
    }

    //get-set for State
    String getState(){
        return State;
    }

    void setState(String State){
        this.State = State;
    }

    //get-set for PostalCode
    String getPostalCode(){
        return PostalCode;
    }

    void setPostalCode(String PostalCode){
        this.PostalCode = PostalCode;
    }

    //get-set for Country
    String getCountry(){
        return Country;
    }

    void setCountry(String Country){
        this.Country = Country;
    }
}

//class AddressParser to parse the address
public class AddressParser extends Address{

    PrintStream ps;
    BufferedReader br;
    FileInputStream fin;
    FileOutputStream fout;
    String Address = "";
    String source = System.getProperty("user.dir")+ "\\source.txt";
    String output = System.getProperty("user.dir")+ "\\output.txt";
    
    //Constructor for Address
    AddressParser(){
        String adrstr = "SOURCE FILE  ADDRESS:-\t" + source + "\n\n";
        adrstr += "OUTPUT FILE ADDRESS:-\t" + output;
        
        JOptionPane.showMessageDialog(null,adrstr);

        setFileStream();

        while(getNextAddress()){
            if(Address.equals(""))
                continue;
            
            parseAddress();
            setAddress();
        }

        try{
            fin.close();
            fout.close();
        }
        catch(IOException ie){
            ie.printStackTrace();
        }
    }

    //function to parse various components of an address
    private void parseAddress(){
        
        //get the postal code and country out of the address
        boolean flag = false;
        int startindex=-1,endindex=-1;
        
        for(int i=Address.length()-1;i>=0;i--){
            if(!flag && Address.charAt(i)>='0' && Address.charAt(i)<='9'){
                flag = true;
                endindex = i+1;
                continue;
            }

            if(flag && (Address.charAt(i)=='-' || (Address.charAt(i)>='0' && Address.charAt(i)<='9'))){
                startindex = i;
            }
            
            else{
                if((i+1)<Address.length() && Address.charAt(i+1)=='-')
                    startindex = i+2;

                if((endindex - startindex)>=4)
                    break;

                flag = false;               
            }   
        }

        if(startindex!=-1 && endindex!=-1){
            setPostalCode(Address.substring(startindex, endindex).replaceAll(",",""));
            setCountry(Address.substring(endindex,Address.length()).replaceAll(",",""));
        }

        if(startindex==-1 || endindex==-1){ //if postal code is not given
            setState(Address.substring(Address.lastIndexOf(","),Address.length()).replaceAll(",","").trim());

            endindex = Address.lastIndexOf(",");
            for(int i=Address.lastIndexOf(",")-1;i>=0;i--){
                startindex = i;

                if(Address.charAt(i)==',')
                    break;
            }

            setCity(Address.substring(startindex, endindex).replaceAll(",","").trim());
        }

        else{
            //find the city  and the state if postal code is give
            endindex = startindex;
            for(int i=startindex;i>=0;i--){
                startindex = i;

                if(Address.charAt(i)==','){
                    if(Address.substring(startindex,endindex).replaceAll(",","").replaceAll("-","").trim().equals(""))
                        endindex = startindex;
                    else
                        break;
                }
            }

            String tempstr = Address;
            Address = Address.substring(startindex, endindex);
            Address = Address.replaceAll(",","");
            Address = Address.replaceAll("-","");
            Address = Address.replaceAll("  "," ");
            Address = Address.trim();

            int lastindex = Address.lastIndexOf(" ");
        
            if(lastindex!=-1){
                setState(Address.substring(lastindex).trim());
                setCity(Address.substring(0,lastindex).trim());
            }
            else
                setCity(Address);

            Address = tempstr;
        }

        Address = Address.substring(0,startindex);

        //finding the locality and the street
        int lastindex = Address.lastIndexOf(",");

        if(lastindex!=-1){
            setLocality(Address.substring(lastindex+1));
            setStreet(Address.substring(0,lastindex));
        }
        else
            setLocality(Address);
               
    }

    //function to write the parsed address in an output file
    private void setAddress(){

        Address = getStreet() + "|" + getLocality() + "|";
        Address += getCity() + "|" + getState() + "|";
        Address += getPostalCode() + "|" + getCountry();

        setState("");
        setStreet("");
        setCountry("");
        setPostalCode("");
        setLocality("");
        setCity("");

        ps.println(Address);
        ps.println();
    }

    //function to obtain address from the source address file
    private boolean getNextAddress(){
        String tempstr = "";
        try {
            Address = "";
            while(true){
                tempstr = br.readLine();

                
                if(tempstr==null)
                    break;
                if(tempstr.trim().equals(""))
                    break;

                Address += tempstr.trim() + ",";
                
            }
            
        }
        catch(IOException ie) {
            ie.printStackTrace();
        }

        if(!Address.equals(""))
            Address = Address.substring(0,Address.length()-1);
        
        if(tempstr==null && Address.equals(""))
            return false;
        
        return true;
    }

    //initialize all input & output streams
    private void setFileStream(){
        try{
            fin = new FileInputStream(source);
            br = new BufferedReader(new InputStreamReader(fin));

            fout = new FileOutputStream(output);
            ps = new PrintStream(fout);
        }
        catch(FileNotFoundException fne){
            System.out.println("THE SOURCE ADDRESS FILE IS NOT FOUND");
            fne.printStackTrace();
        }
    }
    
    //main method for address
    public static void main(String[] args) {
        new AddressParser();
    }

}
