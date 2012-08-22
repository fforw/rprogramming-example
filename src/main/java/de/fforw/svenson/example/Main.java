package de.fforw.svenson.example;

import org.svenson.ClassNameBasedTypeMapper;
import org.svenson.JSON;
import org.svenson.JSONConfig;
import org.svenson.JSONParser;
import org.svenson.matcher.SubtypeMatcher;

import de.fforw.svenson.examples.model.Base;
import de.fforw.svenson.examples.model.DomainA;

public class Main
{
    
    public static JSONConfig createJSONConfig()
    {
        JSONParser parser = new JSONParser();
        
        /**
         * We want to decide on the type to parse into by a JSON property called "type"
         * which will be automatically provided by de.fforw.svenson.examples.model.Base
         */
        ClassNameBasedTypeMapper typeMapper = new ClassNameBasedTypeMapper();
        
        // the packe we look for the classes by name
        typeMapper.setBasePackage(Base.class.getPackage().getName());
        // doing this forces our result to be an instance of that type 
        typeMapper.setEnforcedBaseType(Base.class);
        typeMapper.setDiscriminatorField("type");

        // we want our typemapper to be active whenever the type system
        // is supposed to use the base class.
        typeMapper.setPathMatcher(new SubtypeMatcher(Base.class));
        parser.setTypeMapper(typeMapper);

        // we leave the JSON generation as default
        return new JSONConfig(new JSON(), parser);
    }

    
    public static void main(String[] args)
    {
        JSONConfig cfg = createJSONConfig();
        
        // convert class to JSON
        JSON jsonGenerator = cfg.getJsonGenerator();
        String jsonOutput = jsonGenerator.forValue(new DomainA());
        System.out.println(jsonOutput);
        
        // and from JSON to Java, automatically correctly typed.
        JSONParser parser = cfg.getJsonParser();
        
        Base parsedA = parser.parse(Base.class, "{\"type\":\"DomainA\", \"foo\": 12}");
        System.out.println(parsedA);
        Base parsedB = parser.parse(Base.class, "{\"type\":\"DomainB\", \"bar\": \"hello\"}");
        System.out.println(parsedB);
    }
}
