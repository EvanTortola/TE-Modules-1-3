package com.techelevator.restock;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRestockDao implements RestockDao {

    private File inputFile;
    private List<RestockProduct> restockProductList = new ArrayList<>();

    public FileRestockDao(File inputFile) {
        this.inputFile = inputFile;
    }

    public List<RestockProduct> getRestockList() {
        try (Scanner fileScanner = new Scanner(inputFile)) {
            int lineCounter = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                lineCounter++;
                String[] lineParts = line.split("\\|");

                if (lineParts.length < 4 || lineParts[2] == null) {
                    throw new IllegalArgumentException("Invalid file format on line " + lineCounter);
                }

                RestockProduct restockProduct = new RestockProduct();
                restockProduct.setSlotName(lineParts[0]);
                restockProduct.setProductName(lineParts[1]);
                restockProduct.setSalePrice(BigDecimal.valueOf(Double.parseDouble(lineParts[2])));
                restockProduct.setProductClass(lineParts[3]);

                restockProductList.add(restockProduct);
            }
        }
        catch(FileNotFoundException e){

        }
        return restockProductList;

    }
}
