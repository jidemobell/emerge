/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.rest.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

/**
 *
 * @author kingsley
 */
public class PrefixHelper {

    public static int getPrefix(String number) {
        PhoneNumber phoneNumber = null;
        final PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
           phoneNumber = phoneUtil.parse(number, "AO");
        } catch (NumberParseException e) {
        }
        
        return phoneNumber.getCountryCode();
    }

}
