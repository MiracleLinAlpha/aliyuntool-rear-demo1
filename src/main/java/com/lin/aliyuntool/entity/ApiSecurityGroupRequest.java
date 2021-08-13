package com.lin.aliyuntool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiSecurityGroupRequest {
    String Policy;
    String way;
    String IpProtocol;
    String PortRange;
    String SourceCidrIp;
    String DestCidrIp;
    String Description;


}
