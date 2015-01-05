/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.profitbricks.binders;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.jclouds.Constants;
import org.jclouds.xml.internal.JAXBParser;

import com.google.inject.name.Named;

public class SOAPParser extends JAXBParser {

   @Inject
   public SOAPParser(@Named(Constants.PROPERTY_PRETTY_PRINT_PAYLOADS) String prettyPrint) {
      super("false");
   }

   public SOAPMessage parse(String xml) throws IOException, SOAPException {
      return parse(new ByteArrayInputStream(xml.getBytes(Charset.defaultCharset())));
   }

   public SOAPMessage parse(InputStream stream) throws SOAPException, IOException {
      try {
         return MessageFactory.newInstance().createMessage(null, stream);
      } finally {
         stream.close();
      }
   }

   // FIXME Implement #fromXML(InputStream stream, Class type) version
   @Override
   public <T> T fromXML(String xml, Class<T> type) throws IOException {
      try {
         SOAPMessage message = parse(xml);

         JAXBContext context = JAXBContext.newInstance(type);
         Unmarshaller unmarshaller = context.createUnmarshaller();
         return (T) unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
      } catch (Exception ex) {
         throw new IOException("Could not unmarshal document into type: " + type.getSimpleName() + "\n" + xml, ex);
      }
   }

}
