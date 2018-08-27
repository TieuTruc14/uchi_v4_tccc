/**
 * Created by tieut on 10/27/2017.
 */
//dùng cho edit span trong noi dung hop dong online ma ko phai dung den xedittable angularjs
app.directive('editspan', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, ctrl) {
            // view -> model
            element.bind('blur', function() {
                scope.$apply(function() {
                    ctrl.$setViewValue(element.html());
                });
            });

            // model -> view
            ctrl.$render = function() {
                element.html(ctrl.$viewValue);
            };

            // load init value from DOM
            ctrl.$render();
        }
    };
});