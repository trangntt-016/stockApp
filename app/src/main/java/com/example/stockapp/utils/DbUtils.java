package com.example.stockapp.utils;

public class DbUtils {
    public static String getText(){
        String content = "[\n" +
                "    {\n" +
                "        \"symbol\": \"DUK-A\",\n" +
                "        \"sector\": \"utilities\",\n" +
                "        \"securityType\": \"ps\",\n" +
                "        \"bidPrice\": 26.71,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985472631,\n" +
                "        \"lastSalePrice\": 26.71,\n" +
                "        \"lastSaleSize\": 5,\n" +
                "        \"lastSaleTime\": 1638981436275,\n" +
                "        \"volume\": 800\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"ECCC\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973805445,\n" +
                "        \"lastSalePrice\": 25.13,\n" +
                "        \"lastSaleSize\": 100,\n" +
                "        \"lastSaleTime\": 1638977801744,\n" +
                "        \"volume\": 100\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"AMZN\",\n" +
                "        \"sector\": \"retailtrade\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 3518.45,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985561227,\n" +
                "        \"lastSalePrice\": 3519.24,\n" +
                "        \"lastSaleSize\": 5,\n" +
                "        \"lastSaleTime\": 1638985558217,\n" +
                "        \"volume\": 48983\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"TSLA\",\n" +
                "        \"sector\": \"consumerdurables\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 1057.13,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 1062,\n" +
                "        \"askSize\": 100,\n" +
                "        \"lastUpdated\": 1638985561473,\n" +
                "        \"lastSalePrice\": 1057.57,\n" +
                "        \"lastSaleSize\": 100,\n" +
                "        \"lastSaleTime\": 1638985559032,\n" +
                "        \"volume\": 121253\n" +
                "    }, \n" +
                "    {\n" +
                "        \"symbol\": \"MSFT\",\n" +
                "        \"sector\": \"technologyservices\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 331.77,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 331.79,\n" +
                "        \"askSize\": 300,\n" +
                "        \"lastUpdated\": 1638985561514,\n" +
                "        \"lastSalePrice\": 331.79,\n" +
                "        \"lastSaleSize\": 1,\n" +
                "        \"lastSaleTime\": 1638985559454,\n" +
                "        \"volume\": 395332\n" +
                "    }," +
                "    {\n" +
                "        \"symbol\": \"NVDA\",\n" +
                "        \"sector\": \"electronictechnology\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 318.35,\n" +
                "        \"bidSize\": 145,\n" +
                "        \"askPrice\": 319.54,\n" +
                "        \"askSize\": 133,\n" +
                "        \"lastUpdated\": 1638985561487,\n" +
                "        \"lastSalePrice\": 319.56,\n" +
                "        \"lastSaleSize\": 5,\n" +
                "        \"lastSaleTime\": 1638985557452,\n" +
                "        \"volume\": 363059\n" +
                "    }," +
                "    {\n" +
                "        \"symbol\": \"NFLX\",\n" +
                "        \"sector\": \"consumerservices\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 631.87,\n" +
                "        \"bidSize\": 200,\n" +
                "        \"askPrice\": 632.81,\n" +
                "        \"askSize\": 206,\n" +
                "        \"lastUpdated\": 1638985561124,\n" +
                "        \"lastSalePrice\": 632.28,\n" +
                "        \"lastSaleSize\": 2,\n" +
                "        \"lastSaleTime\": 1638985556695,\n" +
                "        \"volume\": 37218\n" +
                "    }," +
                "    {\n" +
                "        \"symbol\": \"FB\",\n" +
                "        \"sector\": \"technologyservices\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 331.83,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 331.97,\n" +
                "        \"askSize\": 100,\n" +
                "        \"lastUpdated\": 1638985560995,\n" +
                "        \"lastSalePrice\": 331.87,\n" +
                "        \"lastSaleSize\": 100,\n" +
                "        \"lastSaleTime\": 1638985557038,\n" +
                "        \"volume\": 338785\n" +
                "    }," +
                "    {\n" +
                "        \"symbol\": \"CPAR\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"NMMCU\",\n" +
                "        \"sector\": \"finance\",\n" +
                "        \"securityType\": \"ut\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"CLRMU\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"SPBO\",\n" +
                "        \"sector\": \"miscellaneous\",\n" +
                "        \"securityType\": \"et\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985241729,\n" +
                "        \"lastSalePrice\": 34.94,\n" +
                "        \"lastSaleSize\": 100,\n" +
                "        \"lastSaleTime\": 1638985061889,\n" +
                "        \"volume\": 2120\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"DBEF\",\n" +
                "        \"sector\": \"miscellaneous\",\n" +
                "        \"securityType\": \"et\",\n" +
                "        \"bidPrice\": 39.17,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 39.21,\n" +
                "        \"askSize\": 300,\n" +
                "        \"lastUpdated\": 1638985560485,\n" +
                "        \"lastSalePrice\": 39.2,\n" +
                "        \"lastSaleSize\": 100,\n" +
                "        \"lastSaleTime\": 1638985527234,\n" +
                "        \"volume\": 6604\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"CSML\",\n" +
                "        \"sector\": \"miscellaneous\",\n" +
                "        \"securityType\": \"et\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"ASR\",\n" +
                "        \"sector\": \"transportation\",\n" +
                "        \"securityType\": \"ad\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 198.81,\n" +
                "        \"askSize\": 200,\n" +
                "        \"lastUpdated\": 1638985534012,\n" +
                "        \"lastSalePrice\": 198.22,\n" +
                "        \"lastSaleSize\": 200,\n" +
                "        \"lastSaleTime\": 1638985339493,\n" +
                "        \"volume\": 997\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"ZECP\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 26.12,\n" +
                "        \"lastSaleSize\": 1,\n" +
                "        \"lastSaleTime\": 1638980735957,\n" +
                "        \"volume\": 1\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"EVF\",\n" +
                "        \"sector\": \"miscellaneous\",\n" +
                "        \"securityType\": \"cef\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 6.76,\n" +
                "        \"askSize\": 100,\n" +
                "        \"lastUpdated\": 1638984965698,\n" +
                "        \"lastSalePrice\": 6.72,\n" +
                "        \"lastSaleSize\": 100,\n" +
                "        \"lastSaleTime\": 1638980291963,\n" +
                "        \"volume\": 300\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"ITB\",\n" +
                "        \"sector\": \"miscellaneous\",\n" +
                "        \"securityType\": \"et\",\n" +
                "        \"bidPrice\": 82.15,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 82.17,\n" +
                "        \"askSize\": 100,\n" +
                "        \"lastUpdated\": 1638985561001,\n" +
                "        \"lastSalePrice\": 82.22,\n" +
                "        \"lastSaleSize\": 188,\n" +
                "        \"lastSaleTime\": 1638985478514,\n" +
                "        \"volume\": 7125\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"KOPN\",\n" +
                "        \"sector\": \"electronictechnology\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 5.06,\n" +
                "        \"bidSize\": 394,\n" +
                "        \"askPrice\": 5.08,\n" +
                "        \"askSize\": 608,\n" +
                "        \"lastUpdated\": 1638985511927,\n" +
                "        \"lastSalePrice\": 5.075,\n" +
                "        \"lastSaleSize\": 7,\n" +
                "        \"lastSaleTime\": 1638985553582,\n" +
                "        \"volume\": 7575\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"ECPG\",\n" +
                "        \"sector\": \"finance\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 56.63,\n" +
                "        \"bidSize\": 200,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985556282,\n" +
                "        \"lastSalePrice\": 56.72,\n" +
                "        \"lastSaleSize\": 30,\n" +
                "        \"lastSaleTime\": 1638985543149,\n" +
                "        \"volume\": 5295\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"GLLIU\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 10.15,\n" +
                "        \"askSize\": 100,\n" +
                "        \"lastUpdated\": 1638985522208,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"OEPW\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 10,\n" +
                "        \"askSize\": 400,\n" +
                "        \"lastUpdated\": 1638973803973,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"SIM\",\n" +
                "        \"sector\": \"producermanufacturing\",\n" +
                "        \"securityType\": \"ad\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"IDOG\",\n" +
                "        \"sector\": \"miscellaneous\",\n" +
                "        \"securityType\": \"et\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"EWG\",\n" +
                "        \"sector\": \"miscellaneous\",\n" +
                "        \"securityType\": \"et\",\n" +
                "        \"bidPrice\": 32.9,\n" +
                "        \"bidSize\": 728,\n" +
                "        \"askPrice\": 32.91,\n" +
                "        \"askSize\": 2400,\n" +
                "        \"lastUpdated\": 1638985560997,\n" +
                "        \"lastSalePrice\": 32.89,\n" +
                "        \"lastSaleSize\": 300,\n" +
                "        \"lastSaleTime\": 1638984470238,\n" +
                "        \"volume\": 15062\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"BEDU\",\n" +
                "        \"sector\": \"commercialservices\",\n" +
                "        \"securityType\": \"ad\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985288279,\n" +
                "        \"lastSalePrice\": 1.705,\n" +
                "        \"lastSaleSize\": 100,\n" +
                "        \"lastSaleTime\": 1638978904057,\n" +
                "        \"volume\": 100\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"THCAW\",\n" +
                "        \"sector\": \"finance\",\n" +
                "        \"securityType\": \"wt\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973805360,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"SVOKU\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 9.33,\n" +
                "        \"bidSize\": 601,\n" +
                "        \"askPrice\": 10.45,\n" +
                "        \"askSize\": 700,\n" +
                "        \"lastUpdated\": 1638985303121,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"BAC\",\n" +
                "        \"sector\": \"finance\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 44.21,\n" +
                "        \"bidSize\": 300,\n" +
                "        \"askPrice\": 44.22,\n" +
                "        \"askSize\": 900,\n" +
                "        \"lastUpdated\": 1638985561297,\n" +
                "        \"lastSalePrice\": 44.225,\n" +
                "        \"lastSaleSize\": 280,\n" +
                "        \"lastSaleTime\": 1638985521812,\n" +
                "        \"volume\": 454675\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"PPHPW\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"ZIM\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 60.21,\n" +
                "        \"askSize\": 200,\n" +
                "        \"lastUpdated\": 1638985557451,\n" +
                "        \"lastSalePrice\": 58.16,\n" +
                "        \"lastSaleSize\": 10,\n" +
                "        \"lastSaleTime\": 1638985514775,\n" +
                "        \"volume\": 190469\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"EVV\",\n" +
                "        \"sector\": \"miscellaneous\",\n" +
                "        \"securityType\": \"cef\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985561017,\n" +
                "        \"lastSalePrice\": 13.175,\n" +
                "        \"lastSaleSize\": 300,\n" +
                "        \"lastSaleTime\": 1638981838299,\n" +
                "        \"volume\": 315\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"AGR\",\n" +
                "        \"sector\": \"utilities\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 50.86,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985552831,\n" +
                "        \"lastSalePrice\": 50.84,\n" +
                "        \"lastSaleSize\": 1,\n" +
                "        \"lastSaleTime\": 1638985521241,\n" +
                "        \"volume\": 6625\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"FCT\",\n" +
                "        \"sector\": \"miscellaneous\",\n" +
                "        \"securityType\": \"cef\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 11.82,\n" +
                "        \"askSize\": 188,\n" +
                "        \"lastUpdated\": 1638985262709,\n" +
                "        \"lastSalePrice\": 11.82,\n" +
                "        \"lastSaleSize\": 12,\n" +
                "        \"lastSaleTime\": 1638985262709,\n" +
                "        \"volume\": 1930\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"COWN\",\n" +
                "        \"sector\": \"finance\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 35.58,\n" +
                "        \"bidSize\": 200,\n" +
                "        \"askPrice\": 35.7,\n" +
                "        \"askSize\": 133,\n" +
                "        \"lastUpdated\": 1638985542053,\n" +
                "        \"lastSalePrice\": 35.68,\n" +
                "        \"lastSaleSize\": 1,\n" +
                "        \"lastSaleTime\": 1638985159663,\n" +
                "        \"volume\": 4054\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"MAT\",\n" +
                "        \"sector\": \"consumerdurables\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985551322,\n" +
                "        \"lastSalePrice\": 21.695,\n" +
                "        \"lastSaleSize\": 2,\n" +
                "        \"lastSaleTime\": 1638985547591,\n" +
                "        \"volume\": 44546\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"MCAFU\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 10.34,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 11.2,\n" +
                "        \"askSize\": 200,\n" +
                "        \"lastUpdated\": 1638984215940,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"API\",\n" +
                "        \"sector\": \"technologyservices\",\n" +
                "        \"securityType\": \"ad\",\n" +
                "        \"bidPrice\": 19.16,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985560988,\n" +
                "        \"lastSalePrice\": 19.18,\n" +
                "        \"lastSaleSize\": 100,\n" +
                "        \"lastSaleTime\": 1638985559310,\n" +
                "        \"volume\": 22389\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"EPHY\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 9.9,\n" +
                "        \"askSize\": 200,\n" +
                "        \"lastUpdated\": 1638977624827,\n" +
                "        \"lastSalePrice\": 9.785,\n" +
                "        \"lastSaleSize\": 40,\n" +
                "        \"lastSaleTime\": 1638978068188,\n" +
                "        \"volume\": 40\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"BSMM\",\n" +
                "        \"sector\": \"miscellaneous\",\n" +
                "        \"securityType\": \"et\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"KMPR\",\n" +
                "        \"sector\": \"finance\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 54.81,\n" +
                "        \"askSize\": 200,\n" +
                "        \"lastUpdated\": 1638985558956,\n" +
                "        \"lastSalePrice\": 54.71,\n" +
                "        \"lastSaleSize\": 100,\n" +
                "        \"lastSaleTime\": 1638985520713,\n" +
                "        \"volume\": 3754\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"BATRA\",\n" +
                "        \"sector\": \"consumerservices\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 28.36,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985506294,\n" +
                "        \"lastSalePrice\": 28.36,\n" +
                "        \"lastSaleSize\": 100,\n" +
                "        \"lastSaleTime\": 1638985506294,\n" +
                "        \"volume\": 1507\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"PSB-X\",\n" +
                "        \"sector\": \"finance\",\n" +
                "        \"securityType\": \"ps\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"DDEC\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"GASS\",\n" +
                "        \"sector\": \"transportation\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 2.52,\n" +
                "        \"askSize\": 200,\n" +
                "        \"lastUpdated\": 1638984555347,\n" +
                "        \"lastSalePrice\": 2.49,\n" +
                "        \"lastSaleSize\": 100,\n" +
                "        \"lastSaleTime\": 1638984555345,\n" +
                "        \"volume\": 500\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"IDRV\",\n" +
                "        \"sector\": \"miscellaneous\",\n" +
                "        \"securityType\": \"et\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 55.555,\n" +
                "        \"lastSaleSize\": 600,\n" +
                "        \"lastSaleTime\": 1638984719586,\n" +
                "        \"volume\": 2300\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"ANNX\",\n" +
                "        \"sector\": \"healthtechnology\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 16.88,\n" +
                "        \"bidSize\": 133,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985556357,\n" +
                "        \"lastSalePrice\": 16.88,\n" +
                "        \"lastSaleSize\": 45,\n" +
                "        \"lastSaleTime\": 1638985546148,\n" +
                "        \"volume\": 9501\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"NUS\",\n" +
                "        \"sector\": \"consumernon-durables\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 44.1,\n" +
                "        \"bidSize\": 200,\n" +
                "        \"askPrice\": 45.87,\n" +
                "        \"askSize\": 100,\n" +
                "        \"lastUpdated\": 1638985560933,\n" +
                "        \"lastSalePrice\": 45.85,\n" +
                "        \"lastSaleSize\": 12,\n" +
                "        \"lastSaleTime\": 1638985505116,\n" +
                "        \"volume\": 6550\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"GNK\",\n" +
                "        \"sector\": \"transportation\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985542051,\n" +
                "        \"lastSalePrice\": 16.44,\n" +
                "        \"lastSaleSize\": 14,\n" +
                "        \"lastSaleTime\": 1638985487803,\n" +
                "        \"volume\": 17251\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"CGAU\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 7.12,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 7.18,\n" +
                "        \"askSize\": 100,\n" +
                "        \"lastUpdated\": 1638985509381,\n" +
                "        \"lastSalePrice\": 7.14,\n" +
                "        \"lastSaleSize\": 15,\n" +
                "        \"lastSaleTime\": 1638984713804,\n" +
                "        \"volume\": 115\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"SMAP\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 10.42,\n" +
                "        \"askSize\": 500,\n" +
                "        \"lastUpdated\": 1638973804036,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"SVVC\",\n" +
                "        \"sector\": \"finance\",\n" +
                "        \"securityType\": \"cef\",\n" +
                "        \"bidPrice\": 4.23,\n" +
                "        \"bidSize\": 200,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638975619599,\n" +
                "        \"lastSalePrice\": 0,\n" +
                "        \"lastSaleSize\": 0,\n" +
                "        \"lastSaleTime\": 0,\n" +
                "        \"volume\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"ZIEXT\",\n" +
                "        \"sector\": \"n/a\",\n" +
                "        \"securityType\": \"n/a\",\n" +
                "        \"bidPrice\": 0,\n" +
                "        \"bidSize\": 0,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638973800001,\n" +
                "        \"lastSalePrice\": 1,\n" +
                "        \"lastSaleSize\": 2000,\n" +
                "        \"lastSaleTime\": 1638973800001,\n" +
                "        \"volume\": 2000\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"AVD\",\n" +
                "        \"sector\": \"processindustries\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 15.31,\n" +
                "        \"bidSize\": 200,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985556472,\n" +
                "        \"lastSalePrice\": 15.335,\n" +
                "        \"lastSaleSize\": 100,\n" +
                "        \"lastSaleTime\": 1638985414221,\n" +
                "        \"volume\": 1335\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"WAL\",\n" +
                "        \"sector\": \"finance\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 109.58,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 0,\n" +
                "        \"askSize\": 0,\n" +
                "        \"lastUpdated\": 1638985483107,\n" +
                "        \"lastSalePrice\": 109.62,\n" +
                "        \"lastSaleSize\": 67,\n" +
                "        \"lastSaleTime\": 1638985465833,\n" +
                "        \"volume\": 35353\n" +
                "    },\n" +
                "    {\n" +
                "        \"symbol\": \"GOOGL\",\n" +
                "        \"sector\": \"technologyservices\",\n" +
                "        \"securityType\": \"cs\",\n" +
                "        \"bidPrice\": 2945.97,\n" +
                "        \"bidSize\": 100,\n" +
                "        \"askPrice\": 3041.45,\n" +
                "        \"askSize\": 102,\n" +
                "        \"lastUpdated\": 1638985559050,\n" +
                "        \"lastSalePrice\": 2946.43,\n" +
                "        \"lastSaleSize\": 1,\n" +
                "        \"lastSaleTime\": 1638985557455,\n" +
                "        \"volume\": 23557\n" +
                "    },\n"+
                "]";
        return content;
    }
}
