package main.sql.easy;

/*
    Table: Person

    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | PersonId    | int     |
    | FirstName   | varchar |
    | LastName    | varchar |
    +-------------+---------+
    PersonId is the primary key column for this table.
    This table contains information about the ID of some persons and their first and last names.

    Table: Address

    +-------------+---------+
    | Column Name | Type    |
    +-------------+---------+
    | AddressId   | int     |
    | PersonId    | int     |
    | City        | varchar |
    | State       | varchar |
    +-------------+---------+
    AddressId is the primary key column for this table.
    Each row of this table containts information about the city and state of one person with ID = PersonId.

    Write an SQL query to report the first name, last name, city, and state of each person in the Person table. If the address of a PersonId is not present in the Address table, report null instead.

    Return the result table in any order.

    The query result format is in the following example.

    Example 1:

    Input:
    Person table:
    +----------+----------+-----------+
    | PersonId | LastName | FirstName |
    +----------+----------+-----------+
    | 1        | Wang     | Allen     |
    | 2        | Alice    | Bob       |
    +----------+----------+-----------+
    Address table:
    +-----------+----------+---------------+------------+
    | AddressId | PersonId | City          | State      |
    +-----------+----------+---------------+------------+
    | 1         | 2        | New York City | New York   |
    | 2         | 3        | Leetcode      | California |
    +-----------+----------+---------------+------------+
    Output:
    +-----------+----------+---------------+----------+
    | FirstName | LastName | City          | State    |
    +-----------+----------+---------------+----------+
    | Allen     | Wang     | Null          | Null     |
    | Bob       | Alice    | New York City | New York |
    +-----------+----------+---------------+----------+
    Explanation:
    There is no address in the address table for the PersonId = 1 so we return null in their city and state.
    AddressId = 1 contains information about the address of PersonId = 2.
*/

public class _175_CombineTwoTables {
    public static final String query = "SELECT p.FirstName, p.LastName, a.City, a.State\n" +
            "FROM Person p\n" +
            "LEFT JOIN Address a ON a.PersonId = p.PersonId";
}

/*
    Runtime: 320 ms, faster than 59.76% of MySQL online submissions for Combine Two Tables.
    Memory Usage: 0B, less than 100.00% of MySQL online submissions for Combine Two Tables.
*/
