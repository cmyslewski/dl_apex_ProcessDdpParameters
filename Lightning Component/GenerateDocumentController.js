({
	generateDocument : function(component, event, helper) {
        var documentPackageId = component.find('documentPackageId').get('v.value');
        var deliveryOptionId = component.find('deliveryOptionId').get('v.value');
        var recordIds = component.find('recordIds').get('v.value');
        var sObjectType = component.find('sObjectType').get('v.value');
        debugger;

        var body = component.find('body');
        var url = window.location.protocol + '//' + window.location.host + '/apex/ProcessDdp';
        url = url + '?ddpId=' + documentPackageId;
        url = url + '&deliveryOptionId=' + deliveryOptionId;
        url = url + '&ids=' + recordIds;
        url = url + '&sObjectType=' + sObjectType;

        if (!component.get('v.iframeUrl')) {
            component.set('v.iframeUrl', url);
        }
        else {
            // Set blank and then set in order to reset iframe
            component.set('v.iframeUrl', '');
            setTimeout($A.getCallback(function() {
                component.set('v.iframeUrl', url);
            }), 2000);
        }		
	}
})