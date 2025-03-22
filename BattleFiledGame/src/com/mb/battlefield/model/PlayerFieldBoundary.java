package com.mb.battlefield.model;

import com.mb.battlefield.enums.AXIS;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerFieldBoundary {
	private final int start;
	private final int end;
	private final AXIS axis;

}
