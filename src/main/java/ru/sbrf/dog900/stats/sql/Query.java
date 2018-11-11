package ru.sbrf.dog900.stats.sql;

public class Query {
    public static final String BUSINESS_METRICS = "SELECT\n" +
            "        to_char(n.esb_msg_in_created_on,'DD.MM.YYYY')   AS \"ДАТА\",\n" +
            "        s.name                    AS \"ПОТРЕБИТЕЛЬ\",\n" +
            "        t.name                    AS \"ШАБЛОН\",\n" +
            "        CASE t.delivery_type\n" +
            "            WHEN 1   THEN 'PUSH'\n" +
            "            WHEN 2   THEN 'SMS'\n" +
            "            WHEN 3   THEN 'Push по DeviceID'\n" +
            "            ELSE ' '\n" +
            "        end AS \"КАНАЛ\",\n" +
            "        COUNT(n.EXTERNAL_ID) AS \"КОЛИЧЕСТВО\"\n" +
            "    FROM\n" +
            "        dog900_outgoing.notification n\n" +
            "        JOIN dog900_outgoing.msg_type t ON t.id = n.msg_type_id\n" +
            "        JOIN dog900_outgoing.esb_sys_sender s ON s.id = t.esb_sys_sender_id\n" +
            "    WHERE\n" +
            "        s.name in ('SNUIL','UCP')\n" +
            "    GROUP BY\n" +
            "        to_char(n.esb_msg_in_created_on,'DD.MM.YYYY'),\n" +
            "        s.name,\n" +
            "        t.name,\n" +
            "        t.delivery_type;";
}
