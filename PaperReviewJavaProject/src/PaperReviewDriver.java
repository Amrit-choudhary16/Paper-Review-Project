import java.sql.*;

public class PaperReviewDriver {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/paper_reviews";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) {

        try {
            Class.forName(DRIVER);

            Connection conn = DriverManager.getConnection(
                    DATABASE_URL,
                    USER,
                    PASSWORD);

//            Get a submitted paper’s details by the author’s Primary Key. The query should return the
//            following data (columns): Paper.Id, Paper.Title, Paper.Abstract, Author.EmailAddress,
//            Author.FirstName, Author.LastName
            getPaperAuthorDetailsByAuthorId("jamespatterson@author.com", conn);
            lineSpacing();

//            Get all reviews for a paper by the paper’s Id, where the paper was recommended to be
//            published. The query should return the following data (columns): All columns from the
//            Review table.
            getReviewDetailsForRecommendedToPublished(conn);
            lineSpacing();

//            Get a count of all papers submitted.
            getCountOfSubmittedPaper(conn);
            lineSpacing();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    private static void lineSpacing() {
        System.out.println();
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println();
        System.out.println();
    }

    private static void getPaperAuthorDetailsByAuthorId(String key, Connection conn) {

        try {
            Statement stmt = conn.createStatement();

            String sqlStr = "SELECT " +
                    " paper.Id as id, " +
                    " paper.Title as title, " +
                    " paper.Abstract as abstract, " +
                    " author.EmailAddr as email_address," +
                    " author.FirstName as first_name, " +
                    " author.LastName as last_name" +
                    " FROM " +
                    " paper , author" +
                    " where " +
                    " paper.authorId = author.EmailAddr" +
                    " and author.EmailAddr = '" + key + "'";

            ResultSet rset = stmt.executeQuery(sqlStr);

            while (rset.next()) {
                System.out.println("Paper Id is " + rset.getInt("id"));
                System.out.println("Paper Title is " + rset.getString("title"));
                System.out.println("Paper Abstract is " + rset.getString("abstract"));
                System.out.println("Author Email Address is " + rset.getString("email_address"));
                System.out.println("Author First Name is " + rset.getString("first_name"));
                System.out.println("Author Last Name is " + rset.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static void getReviewDetailsForRecommendedToPublished(Connection conn) {

       try {
        Statement stmt = conn.createStatement();

        String sqlStr = "SELECT " +
                " paper.Id as id1,"+
                " review.PaperId as paper_id, " +
                " review.ReviewerId as reviewerid, " +
                " review.Recommendation as recommendation, " +
                " review.MeritScore as mscore," +
                " review.ReadabilityScore as rscore, " +
                " review.OriginalityScore as oscore," +
                " review.RelevanceScore as relscore" +
                " FROM " +
                " review,paper" +
                " where " +
                " paper.Id = review.PaperId" +
                " and review.Recommendation = 'The paper should be read'";

        ResultSet rset = stmt.executeQuery(sqlStr);

        while (rset.next()) {
            System.out.println("Id is " + rset.getInt("id1"));
            System.out.println("Paper Id is " + rset.getString("paper_id"));
            System.out.println("revierId is " + rset.getString("reviewerid"));
            System.out.println("Recommendation is " + rset.getString("recommendation"));
            System.out.println("Merit Score is " + rset.getInt("mscore"));
            System.out.println("Readability score is " + rset.getInt("rscore"));
            System.out.println("Originality score is " + rset.getInt("oscore"));
            System.out.println("Relevance score is " + rset.getInt("relscore"));
            System.out.println();
            System.out.println();
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getCountOfSubmittedPaper(Connection conn) {

        try {
            Statement stmt = conn.createStatement();

            String sqlStr = "SELECT" +
                    " COUNT(*) as count"+
                    " FROM " +
                    " paper_reviews.review";
            ResultSet rset = stmt.executeQuery(sqlStr);
            while (rset.next()) {
                System.out.println("Count is " + rset.getInt("count"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
