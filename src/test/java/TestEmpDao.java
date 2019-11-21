import com.lry.dao.EmpDao;
import com.lry.dao.EmpDaoImpl;
import com.lry.po.Emp;

import java.util.List;

/**
 * @author liurenyi
 * @create 2019--11--21--11:11
 */
public class TestEmpDao {

    @org.junit.Test
    public void textgetSelect() {
        EmpDao empDao=new EmpDaoImpl();
        List<Emp> list = empDao.selectAll();
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
}
