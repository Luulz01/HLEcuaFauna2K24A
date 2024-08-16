import HLDataAccess.HLHormigaDAO;
import HLDataAccess.DTO.HLHormigaDTO;

public class App {
    public static void main(String[] args) throws Exception {
        
        try {
            HLHormigaDAO hDao = new HLHormigaDAO();
            for(HLHormigaDTO h : hDao.readAll())
                System.out.println(h.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    
}
