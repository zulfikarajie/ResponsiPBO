/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplements;

import java.util.List;
import ModelPackage.*;
/**
 *
 * @author apang
 */

public interface PerpusDAOImpl {
    public void insert(ModelData m);
    public void update(ModelData m);
    public void delete(int id);
    public List<ModelData>getALL();
}