package com.manav.ncu;

import java.util.HashMap;
import java.util.Map;

public class RoleMap {
public String getMapping(int i) {
Map<Integer,String> map=new HashMap<>();
map.put(1, "software");
map.put(2, "hardware");
map.put(3, "network");
map.put(4, "enduser");
map.put(5, "manager");
	return map.get(i);
}
}
