package monopoly;
import java.util.Random;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("6a2bdce9-a28e-4261-8d46-1b05207252e9")
public class Des {
    @objid ("4553f076-b7e4-4657-a6ad-9c6eeec856a0")
    private int de1 = 0;

    @objid ("800713fc-063e-4942-8018-b1ab87de37da")
    private int de2 = 0;

    @objid ("ec2f47d3-c0db-4b05-9419-7341a367948b")
    public void lancerDes() {
    	Random random = new Random();
    	de1 = random.nextInt(6)+1;
    	de2 = random.nextInt(6)+1;
    }

    @objid ("ed603c71-d53a-4ecc-a033-1b42c90b315f")
    int getDe1() {
        
        return this.de1;
    }

    @objid ("2057d91a-6c77-4440-b021-5d2c79bd6875")
    void setDe1(int value) {
        
        this.de1 = value;
    }

    @objid ("d6523647-57de-433d-a908-8d7be85d8be6")
    int getDe2() {
        
        return this.de2;
    }

    @objid ("0b7c703e-b746-485a-8ebc-645948358561")
    void setDe2(int value) {
        
        this.de2 = value;
    }

	public boolean verifDouble() {
		if(de1 == de2) {
			return true;
		}else {
			return false;
		}
	}

}
