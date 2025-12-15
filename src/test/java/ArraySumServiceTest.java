import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySumServiceTest {
    private ArraySumService service;
    @BeforeEach
    void setUP(){
        service = new ArraySumService();
    }
    @Test
    void TestSumArray_Manghople(){
        int[] arr ={1,2,3,4,5};
        int ex= 15;
        int re = service.sumArray(arr);
        assertEquals(ex,re);

    }
    //viết thêm 1 số case hợp lệ

    @Test
    void TestSumArray_Mangrnull(){
        assertThrows(IllegalArgumentException.class,() ->service.sumArray(null));
    }
    @Test
    void TestSumArray_Mangam(){
        assertThrows(IllegalArgumentException.class,() ->service.sumArray(new int[]{-1,2,-3}));
    }
    @Test
    void TestSumArray_Manglonhon1000(){
        assertThrows(IllegalArgumentException.class,() ->service.sumArray(new int[]{1500,2000}));
    }

}