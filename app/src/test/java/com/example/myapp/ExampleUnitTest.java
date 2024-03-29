package com.example.myapp;

import com.example.myapp.utils.GenerateValueFile;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void createValueFile(){
        //以baseW baseH为标准的值
        int baseW = 720;
        int baseH = 1196;
        String addition = GenerateValueFile.SUPPORT_DIMESION;
        new GenerateValueFile(baseW, baseH, addition).generate();
    }
}