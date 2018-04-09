package room;

import anno.Direction;

public class Park {
	@Direction(command="go to the road")
	private Road r;
	@Direction(command="go to Mater's House")
	private MaterHouse mh;
	@Direction(command="go to Cozy Cone Motel")
	private CozyConeMotel ccm;
	
}
