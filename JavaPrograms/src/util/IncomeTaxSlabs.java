package util;

public enum IncomeTaxSlabs {
	//OLD REGIME SLABS
	BW0TO5LAKH(0,500000),
	BW2TO5LAKH(250001,500000),
	BW5TO10LAKH(500001,1000000),
	ABOVE10LAKH(1000001,999999999),
	
	//NEW REGIME SLABS
	BW5TO7_5LAKH(500001,750000),
	BW7_5TO10LAKH(750001,1000000),
	BW10TO12_5LAKH(1000001,1250000),
	BW12_5TO15LAKH(1250001,1500000),
	ABOVE15LAKH(1500001,999999999)
	;
	
	private long minValue;
	private long maxValue;
	IncomeTaxSlabs(long min, long max)
	{
	  	this.minValue = min;
	  	this.maxValue = max;
	}
	
	public long getMaxValue(){
	 	return this.maxValue;
	}
	
	public long getMinVaue(){
		return this.minValue;
	}
}
