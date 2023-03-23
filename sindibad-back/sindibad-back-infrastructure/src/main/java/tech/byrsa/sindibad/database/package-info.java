
@TypeDef(name = "json", typeClass = JsonType.class)
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class),
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
package tech.byrsa.sindibad.database;


import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import com.vladmihalcea.hibernate.type.json.JsonType;
