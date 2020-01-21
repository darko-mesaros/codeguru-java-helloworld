package com.example.helloworld;

public class hello_world {
    public static void main(String[] args) {
        System.out.println("Hello Sarajevo");

        do {     
                     DescribeTableResult describe = ddbClient.describeTable(new DescribeTableRequest().withTableName(tableName));
                     String status = describe.getTable().getTableStatus();
                     if (TableStatus.ACTIVE.toString().equals(status)) {
                         return describe.getTable();
                     }
                     
                     if (TableStatus.DELETING.toString().equals(status)) {
                         throw new ResourceInUseException("Table is " + status + ", and waiting for it to become ACTIVE is not useful.");
                     }
                     Thread.sleep(10 * 1000);
                     elapsedMs = System.currentTimeMillis() - startTimeMs;
        } while (elapsedMs / 1000.0 < waitTimeSeconds);
        throw new ResourceInUseException("Table did not become ACTIVE after ");

    }
}
