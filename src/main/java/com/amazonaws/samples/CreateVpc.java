package com.amazonaws.samples;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.CreateVpcRequest;
import com.amazonaws.services.ec2.model.CreateVpcResult;
import com.amazonaws.services.ec2.model.Vpc;

public class CreateVpc
{
	private static final AWSCredentials AWS_CREDENTIALS;
    static 
    {
	        // Your accesskey and secretkey
	        AWS_CREDENTIALS = new BasicAWSCredentials(
	                "AKIARXBJSPVLQJESECGS",
	                "BZCKVq0Xm9whMt1Ij+yD2RaaVhSy52fE2f33dzFR"
	        );
    }
    public static void main(String[] args) 
    {
        // Set up the amazon ec2 client
        AmazonEC2 ec2Client = AmazonEC2ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(AWS_CREDENTIALS))
                .withRegion(Regions.US_EAST_2)
                .build();
        System.out.println("Creating a VPC");
        CreateVpcRequest newVPC = new CreateVpcRequest("In");
        newVPC.setCidrBlock("10.0.0.0/16");
        CreateVpcResult res = ec2Client.createVpc(newVPC);
        Vpc vp = res.getVpc();
        String vpcId = vp.getVpcId();
        System.out.println("Created VPC " + vpcId);
    }
}
