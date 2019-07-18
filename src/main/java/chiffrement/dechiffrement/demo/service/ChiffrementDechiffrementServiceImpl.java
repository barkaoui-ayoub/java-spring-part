package chiffrement.dechiffrement.demo.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.stereotype.Service;

import chiffrement.dechiffrement.demo.common.ChiffrementRequest;
import chiffrement.dechiffrement.demo.common.ChiffrementResponse;
import chiffrement.dechiffrement.demo.common.DechiffrementRequest;
import chiffrement.dechiffrement.demo.common.DechiffrementResponse;

@Service
public class ChiffrementDechiffrementServiceImpl implements ChiffrementDechiffrementService {

	@Override
	public ChiffrementResponse chiffrement(ChiffrementRequest chiffrementRequest) {

		ChiffrementResponse response = new ChiffrementResponse();

		String encodedParam ;
		Security.addProvider(new BouncyCastleProvider());
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setProviderName("BC");
		encryptor.setAlgorithm("PBEWITHSHA256AND128BITAES-CBC-BC");
		encryptor.setPassword(chiffrementRequest.getCle());
		String encryptedParam = encryptor.encrypt(chiffrementRequest.getChaine());
		try {
			encodedParam = URLEncoder.encode(encryptedParam,"UTF-8");
			response.setResponse(encodedParam);
		} catch (UnsupportedEncodingException e) {
			//TODO
		}

		return response;
	}

	@Override
	public DechiffrementResponse dechiffrement(DechiffrementRequest dechiffrementRequest) {

		DechiffrementResponse response = new DechiffrementResponse();

		String cryptedParamDecoded = null;
		Security.addProvider(new BouncyCastleProvider());
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setProviderName("BC");
		encryptor.setAlgorithm("PBEWITHSHA256AND128BITAES-CBC-BC");
		encryptor.setPassword(dechiffrementRequest.getCle());
		try {
			cryptedParamDecoded = URLDecoder.decode(dechiffrementRequest.getChaineCryptee(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			//TODO
		}
		String decryptecdParam = encryptor.decrypt(cryptedParamDecoded);
		response.setResponse(decryptecdParam);

		return response;
	}



}
