package matt.lyoko.model.vehicles;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelOverboard extends ModelVehicle
{
	//fields
	ModelRenderer base;
	ModelRenderer rightEngine;
	ModelRenderer leftEngine;
	ModelRenderer baseFront2;
	ModelRenderer baseFront1;
	ModelRenderer baseMid;
	ModelRenderer baseBack;
	ModelRenderer baseRear1;
	ModelRenderer baseRear2;
	ModelRenderer baseRear3;
	ModelRenderer baseRear4;

	public ModelOverboard() {
		textureWidth = 256;
		textureHeight = 128;

		base = new ModelRenderer(this, 0, 74);
		base.addBox(-3F, -1F, -8F, 6, 2, 14);
		base.setRotationPoint(-7F, 19F, 0F);
		base.setTextureSize(256, 128);
		base.mirror = true;
		setRotation(base, 0F, 0F, 0F);
		rightEngine = new ModelRenderer(this, 65, 0);
		rightEngine.addBox(-4.5F, -2F, -0.5F, 9, 4, 3);
		rightEngine.setRotationPoint(10F, 19F, 6F);
		rightEngine.setTextureSize(256, 128);
		rightEngine.mirror = true;
		setRotation(rightEngine, 0F, 0F, 0F);
		leftEngine = new ModelRenderer(this, 30, 0);
		leftEngine.addBox(-4.5F, -2F, -2.5F, 9, 4, 3);
		leftEngine.setRotationPoint(10F, 19F, -8F);
		leftEngine.setTextureSize(256, 128);
		leftEngine.mirror = true;
		setRotation(leftEngine, 0F, 0F, 0F);
		baseFront2 = new ModelRenderer(this, 0, 90);
		baseFront2.addBox(-1F, -1F, -6F, 1, 2, 12);
		baseFront2.setRotationPoint(-10F, 19F, -1F);
		baseFront2.setTextureSize(256, 128);
		baseFront2.mirror = true;
		setRotation(baseFront2, 0F, 0F, 0F);
		baseFront1 = new ModelRenderer(this, 0, 104);
		baseFront1.addBox(-1F, -1F, -5F, 1, 2, 10);
		baseFront1.setRotationPoint(-11F, 19F, -1F);
		baseFront1.setTextureSize(256, 128);
		baseFront1.mirror = true;
		setRotation(baseFront1, 0F, 0F, 0F);
		baseMid = new ModelRenderer(this, 0, 60);
		baseMid.addBox(-3F, -1F, -6F, 6, 2, 12);
		baseMid.setRotationPoint(-1F, 19F, -1F);
		baseMid.setTextureSize(256, 128);
		baseMid.mirror = true;
		setRotation(baseMid, 0F, 0F, 0F);
		baseBack = new ModelRenderer(this, 0, 44);
		baseBack.addBox(-3F, -1F, -8F, 13, 2, 14);
		baseBack.setRotationPoint(5F, 19F, 0F);
		baseBack.setTextureSize(256, 128);
		baseBack.mirror = true;
		setRotation(baseBack, 0F, 0F, 0F);
		baseRear1 = new ModelRenderer(this, 0, 30);
		baseRear1.addBox(0F, -1F, -6F, 1, 2, 12);
		baseRear1.setRotationPoint(15F, 19F, -1F);
		baseRear1.setTextureSize(256, 128);
		baseRear1.mirror = true;
		setRotation(baseRear1, 0F, 0F, 0F);
		baseRear2 = new ModelRenderer(this, 0, 18);
		baseRear2.addBox(0F, -1F, -5F, 1, 2, 10);
		baseRear2.setRotationPoint(16F, 19F, -1F);
		baseRear2.setTextureSize(256, 128);
		baseRear2.mirror = true;
		setRotation(baseRear2, 0F, 0F, 0F);
		baseRear3 = new ModelRenderer(this, 0, 8);
		baseRear3.addBox(0F, -1F, -4F, 1, 2, 8);
		baseRear3.setRotationPoint(17F, 19F, -1F);
		baseRear3.setTextureSize(256, 128);
		baseRear3.mirror = true;
		setRotation(baseRear3, 0F, 0F, 0F);
		baseRear4 = new ModelRenderer(this, 0, 0);
		baseRear4.addBox(0F, -1F, -3F, 1, 2, 6);
		baseRear4.setRotationPoint(18F, 19F, -1F);
		baseRear4.setTextureSize(256, 128);
		baseRear4.mirror = true;
		setRotation(baseRear4, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		base.render(f5);
		rightEngine.render(f5);
		leftEngine.render(f5);
		baseFront2.render(f5);
		baseFront1.render(f5);
		baseMid.render(f5);
		baseBack.render(f5);
		baseRear1.render(f5);
		baseRear2.render(f5);
		baseRear3.render(f5);
		baseRear4.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
