package jchef.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONFileParser {
    private JSONBuilder builder;
    private JSONParser parser;

    /**
     * Constructor
     *
     * @param builder builder to use when parsing
     */
    public JSONFileParser(JSONBuilder builder) {
        this.builder = builder;
        parser = new JSONParser();
    }

    /**
     * Parse the given file by calling builder.buildEntry(entry) for each entry
     *
     * @param filename name of the file to parse
     */
    public void parse(String filename)
    {
        try {
            //Open file and read to array
            JSONArray entries = (JSONArray) parser.parse(new FileReader(filename));

            //Call builder for every entry
            for(Object entry: entries)
            {
                builder.buildEntry((JSONObject) entry);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
