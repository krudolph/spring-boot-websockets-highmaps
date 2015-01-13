var bubbleData;
var mapDataUpdates;

$(function () {

  var mapData = Highcharts.maps['countries/de/de-all-all'];

  $('#container').highcharts('Map', {

    title: {
      text : false
    },

    legend: {
      enabled: false
    },

    chart : {
      events : {
        load : function() {
          bubbleData = this.series[0];
          mapDataUpdates = this.series[1];
        }
      }
    },

    colorAxis: {
      min: 0,
      max: 100,
      minColor: '#eeeeee',
      maxColor: '#000000'
    },

    series:
            [
              {
                type: 'mapbubble',
                mapData: mapData,
                joinBy: 'hc-key',
                zIndex: 11,
                data : []
              },
              {
                mapData: mapData,
                joinBy: 'hc-key',
                zIndex: 10,
                data :[{}]
               }
            ]
  });

});

var socket = new SockJS('/random');
var client = Stomp.over(socket);

client.connect('user', 'password', function(frame) {

  client.subscribe("/bubbles", function(message) {
    var shift = bubbleData.data.length > 10;
    bubbleData.addPoint(JSON.parse(message.body), true, shift, true);
  });

  client.subscribe("/map", function(message) {
    mapDataUpdates.setData(JSON.parse(message.body));
  });

});