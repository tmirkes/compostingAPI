package persistence;

import entity.Material;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type material dao test.
 */
class MaterialDaoTest {
    GenericDao dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Material.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all material's success.
     */
    @Test
    void getAllMaterialsSuccess() {
        assertEquals(10, dao.getAll().size());
    }

    /**
     * Verifies a materials are returned correctly based on id search.
     */
    @Test
    void getByIdSuccess() {
        Material retrievedMaterial = (Material) dao.getById(5);
        assertNotNull(retrievedMaterial);
        int expected = 5;
        int actual = retrievedMaterial.getId();
        assertEquals(expected, actual);
    }
    /**
     * Verify successful insert of a material
     */
    @Test
    void insertSuccess() {

        Material newMaterial = new Material("sample material", "sample material comment");
        int id = dao.addEntity(newMaterial);
        assertNotEquals(0,id);
        Material insertedMaterial = (Material) dao.getById(id);
        assertEquals(newMaterial, insertedMaterial);
    }

    /**
     * Verify successful delete of a material
     */
    @Test
    void deleteSuccess() {
        dao.deleteEntity(dao.getById(2));
        assertNull(dao.getById(12));
    }

    /**
     * Verify successful update of a material
     */
    @Test
    void updateSuccess() {
        String newComment = "Probably a little old and crunchy";
        Material updateMaterial = (Material) dao.getById(3);
        updateMaterial.setComments(newComment);
        dao.editEntity(updateMaterial);
        Material retrievedMaterial = (Material) dao.getById(3);
        assertEquals(updateMaterial, retrievedMaterial);
    }
}
