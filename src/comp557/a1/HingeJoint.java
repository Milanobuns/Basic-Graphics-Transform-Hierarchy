//Milan Singh 260654803
package comp557.a1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

import mintools.parameters.DoubleParameter;

public class HingeJoint extends DAGNode {
	DoubleParameter angle;
	float tx, ty, tz;
	float cr, cg, cb;
	float ax, ay, az; //Axis for rotation
	
	
	HingeJoint( String name,
				float _tx, float _ty, float _tz,
				float _cr, float _cg, float _cb,
				float minAngle, float maxAngle,
				float _ax, float _ay, float _az )
	{
		super(name);
		
		this.tx	= _tx;
		this.ty	= _ty;
		this.tz	= _tz;

		this.cr	= _cr;
		this.cg	= _cg;
		this.cb	= _cb;

		this.ax	= _ax;
		this.ay	= _ay;
		this.az	= _az;
		
		dofs.add( angle = new DoubleParameter( name+" Angle", 1, minAngle, maxAngle ) );	
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glColor3f( cr, cg, cb );
		
		gl.glPushMatrix();
		
		gl.glTranslatef( tx, ty, tz );
		
        gl.glRotatef( angle.getFloatValue(), ax, ay, az);
                
        // Draw something interesting
        glut.glutSolidSphere( 0.25f, 10, 10 );

        super.display(drawable);

		gl.glPopMatrix();

	}
}
