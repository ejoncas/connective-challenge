WITH consecutive_counts_data AS (
    SELECT num, COUNT(*) consecutive_count
    FROM (
      SELECT *, SUM(flag) OVER (ORDER BY id) num_group
      FROM (
        SELECT *, (num <> LAG(num, 1, '') OVER (ORDER BY id))::int flag
        FROM logs
      ) t
    ) t
    GROUP BY num_group, num
    ORDER BY num_group
)
SELECT num conecutive_nums FROM consecutive_counts_data WHERE consecutive_count >=3