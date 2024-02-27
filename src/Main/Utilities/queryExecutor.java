package Main.Utilities;

import Main.Database.DatabaseHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class queryExecutor {

    //Current placeholder symbol for Prepared Statements
    private static final char PLACEHOLDER_SYMBOL = '?';

    /**
     * Executes a SQL statement with the provided parameters.
     *
     * @param sql    The SQL statement to be executed.
     * @param params The parameters to be set in the prepared statement.
     */
    public static void executeStatement(String sql, Object... params){

        Connection connection = getDbConnection();

        if(countPlaceholders(sql) != params.length){
            throw new IllegalArgumentException(
                    "Invalid number of parameters. Expected: " + countPlaceholders(sql) + ", Actual: " + params.length
            );
        }

        //try-with-resources for preparedStatement
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setParams(preparedStatement, params);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * Sets parameters in a PreparedStatement, ensuring the length of params matches the number of placeholders.
     *
     * @param preparedStatement The prepared statement to set parameters for.
     * @param params            The parameters to set.
     * @throws IllegalArgumentException If the length of params does not match the number of placeholders.
     */
    private static void setParams(PreparedStatement preparedStatement, Object... params) throws IllegalArgumentException{

        for(int i =0; i<params.length;++i){
            try{
                preparedStatement.setObject(i + 1, params[i]);
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }


    /**
     * Counts the number of placeholders in a prepared statement's SQL.
     *
     * @param sql The prepared statement to count placeholders for.
     * @return The number of placeholders in the SQL.
     */
    private static int countPlaceholders(String sql){
        int count = 0;

        //Count Placeholder Symbols in String
        for(int i = 0; i < sql.length(); ++i){
            if(sql.charAt(i) == PLACEHOLDER_SYMBOL) count++;
        }
        return count;
    }

    /**
     * Gets a database connection from the DatabaseHandler singleton.
     *
     * @return The database connection.
     */
    private static Connection getDbConnection(){
        DatabaseHandler db = DatabaseHandler.getInstance();
        db.connect();
        return db.getConnection();
    }
}
