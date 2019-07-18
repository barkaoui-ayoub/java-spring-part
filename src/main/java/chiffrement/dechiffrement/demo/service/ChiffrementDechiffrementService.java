package chiffrement.dechiffrement.demo.service;

import chiffrement.dechiffrement.demo.common.ChiffrementRequest;
import chiffrement.dechiffrement.demo.common.ChiffrementResponse;
import chiffrement.dechiffrement.demo.common.DechiffrementRequest;
import chiffrement.dechiffrement.demo.common.DechiffrementResponse;

public interface ChiffrementDechiffrementService {

	public ChiffrementResponse chiffrement (ChiffrementRequest chiffrementRequest);
	public DechiffrementResponse dechiffrement (DechiffrementRequest dechiffrementRequest);
	
}
