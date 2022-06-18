WITH consecutive_counts_data AS (
    SELECT num, COUNT(*) consecutive_count
    FROM (
      -- Here we're assigning numbers to each group of consecutive repetitions
      SELECT *, SUM(first_appearance_flag) OVER (ORDER BY id) num_group
      FROM (
      -- LAG function is comparing number on the current row against the previos row
        SELECT *, (num <> LAG(num, 1, '') OVER (ORDER BY id))::int first_appearance_flag
        FROM logs
      ) t
    ) t
    GROUP BY num_group, num
    ORDER BY num_group
)
-- finally we select just the ones that have 3 or more consecutive repetitions
SELECT num consecutive_nums FROM consecutive_counts_data WHERE consecutive_count >=3