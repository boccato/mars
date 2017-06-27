package com.example.mars;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/rest/mars/{cmd}")
    public String greeting(@PathVariable("cmd") String cmd) throws BadCommandException{
    	MarsTerrain terrain = new MarsTerrain(5, 5);
    	MarsPosition startPosition = new MarsPosition(0, 0, 'N');
    	MarsBotNavigator nav = new MarsBotNavigator(startPosition, terrain);

    	Optional<MarsPosition> finalPosition = nav.execute(cmd);
    	if (finalPosition.isPresent()) {
    		return finalPosition.get().toString();
    	}
    	else {
    		throw new BadCommandException(cmd);
    	}
    }
}
