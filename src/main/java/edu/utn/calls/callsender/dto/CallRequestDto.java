package edu.utn.calls.callsender.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CallRequestDto {
     String origin;
     String destination;
     String datetime;
     Long duration;
}
