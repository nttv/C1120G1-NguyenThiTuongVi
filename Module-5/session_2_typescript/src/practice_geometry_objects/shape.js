"use strict";
exports.__esModule = true;
exports.Shape = void 0;
var Shape = /** @class */ (function () {
    // private _x: number;
    // private _y: number;
    function Shape(_x, _y) {
        this._x = _x;
        this._y = _y;
        // this._x = x;
        // this._y = y;
    }
    Object.defineProperty(Shape.prototype, "y", {
        get: function () {
            return this._y;
        },
        set: function (y) {
            this._y = y;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Shape.prototype, "x", {
        get: function () {
            return this._x;
        },
        set: function (x) {
            this._x = x;
        },
        enumerable: false,
        configurable: true
    });
    Shape.prototype.toString = function () {
        return "(x: " + this._x + ", y: " + this._y + ")";
    };
    return Shape;
}());
exports.Shape = Shape;
