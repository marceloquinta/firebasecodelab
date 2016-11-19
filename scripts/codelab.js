(function(window, document){
'use strict';window.ga&&window.ga(function(){var b=window.location;window.ga.getAll().forEach(function(a){"file:"===b.protocol&&(a.set("checkProtocolTask",null),a.set("checkStorageTask",null),a.set("dataSource","offline"),a.set("location","https://offline"+b.pathname));a.send("pageview")})});
})(window, document);
